package problem;

import com.sun.org.apache.bcel.internal.generic.POP;
import config.Config;
import crossover.CrossoverOperator;
import crossover.PMXCrossover;
import generator.PopulationGenerator;
import loader.Loader;
import model.*;
import mutation.MutationOperator;
import mutation.SwapMutation;
import selection.RouletteSelectionStrategy;
import selection.SelectionStrategy;
import utils.MathUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static config.Config.*;
import static java.util.Arrays.asList;

/**
 * Created by Cinek on 10.03.2019.
 */
public class GeneticAlgorithm {

    private Problem problem;
    private MutationOperator mutationOperator;
    private CrossoverOperator crossoverOperator;
    private SelectionStrategy selectionStrategy;

    public GeneticAlgorithm(Problem problem, MutationOperator mutationOperator, CrossoverOperator crossoverOperator, SelectionStrategy selectionStrategy) {
        this.problem = problem;
        this.mutationOperator = mutationOperator;
        this.crossoverOperator = crossoverOperator;
        this.selectionStrategy = selectionStrategy;
    }

    public static void main(String[] args) {
        Loader loader = new Loader();
        Problem problem = null;
        try {
            problem = loader.loadProblemData("C:\\Users\\Cinek\\Documents\\projektyJAVA\\ttp_problem_ga\\src\\main\\resources\\medium_0.ttp");
            System.out.println("problem data loaded");
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(problem, new SwapMutation(), new PMXCrossover(), new RouletteSelectionStrategy());
            geneticAlgorithm.run();





        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

    public void run()
    {
        Population population = PopulationGenerator.generatePopulation(0, POPULATION_SIZE,  problem.getDimension() );
        List<Population> populations = new ArrayList<>(POPULATION_SIZE);

        KnapsackProblemSolution knapsackProblemSolution = solveKnapsackProblemGreedy();

        populations.add(population);
        evaluate(population, knapsackProblemSolution);

        printPopulationResults(population);

        for (int gen = 0; gen< GENERATIONS; gen++)
        {

            List<Solution> solutions = new ArrayList<>(POPULATION_SIZE);
            for (int i=0; i<POPULATION_SIZE; i++)
            {
                Solution parent1 = selectionStrategy.selection(population);
                Solution result = parent1;

                double rand = Math.random();
                if (rand<= CROSSOVER_PROB )
                {
                    int randIndex = MathUtils.randInt(0, POPULATION_SIZE);
                    Solution parent2 = population.getSolutions().get(randIndex);

                    result = crossoverOperator.crossover(parent1, parent2);
                }

                mutationOperator.mutate(result);
                solutions.add(result);

            }
            Population newPopulation = new Population(gen+1, solutions);
            populations.add(newPopulation);
            population = newPopulation;
            evaluate(population, knapsackProblemSolution);
            printPopulationResults(newPopulation);
        }


    }

    private boolean isSolutionRight(Solution solution)
    {
        int dimension = solution.getDimension();
        Set<Integer> hashSet = new HashSet<>();
        for (Integer index : solution.getCitiesIndexes())
        {
            hashSet.add(index);
        }
        return dimension==hashSet.size();
    }
    private void printPopulationResults(Population population)
    {
        System.out.println(String.format("Pop: %4d -- Max: %10f -- Min: %10f --  Avg: %10f", population.getIndex(), maxFitness(population),
                minFitness( population ), avgFitness(population)));
    }

    public double maxFitness(Population population)
    {
        Solution solution0  = population.getSolutions().get(0);
        double maxFitness = solution0.getFitness();
        for (int i=1; i<population.getSolutions().size(); i++)
        {
            double fitness = population.getSolutions().get(i).getFitness();
            if (fitness>maxFitness)
            {
                maxFitness = fitness;
            }

        }

        return  maxFitness;
    }

    public double minFitness(Population population)
    {
        Solution solution0  = population.getSolutions().get(0);
        double minFitness = solution0.getFitness();
        for (int i=1; i<population.getSolutions().size(); i++)
        {
            double fitness = population.getSolutions().get(i).getFitness();
            if (fitness<minFitness)
            {
                minFitness = fitness;
            }

        }

        return  minFitness;
    }

    public double avgFitness(Population population)
    {
        double sum = 0;
        for (Solution solution : population.getSolutions())
        {
            sum+= solution.getFitness();
        }
        return sum/population.getSolutions().size();
    }

    public void evaluate(Population population, KnapsackProblemSolution knapsackProblemSolution)
    {
        for (Solution solution: population.getSolutions())
        {
            solution.setFitness(functionG(solution, knapsackProblemSolution));
        }
    }

    public double functionG(Solution solution, KnapsackProblemSolution knapsackProblemSolution)
    {
        return knapsackProblemSolution.getKnapsackValue() - functionF(solution, knapsackProblemSolution);
    }

    public double functionF(Solution solution, KnapsackProblemSolution knapsackProblemSolution) {
        Knapsack knapsack = new Knapsack(problem.getKnapsackCapacity());
        double tsum = 0;
        List<Integer> cityIndexes = solution.getCitiesIndexes();
        int firstCityIndex = cityIndexes.get(0);
        int lastCityIndex = cityIndexes.get(cityIndexes.size()-1 );
        for (int i = 0; i < cityIndexes.size() - 1; i++) {
            int fromIndex = cityIndexes.get(i);
            int toIndex = cityIndexes.get(i + 1);



            tsum +=  calculateTForSingleStep(fromIndex, toIndex, knapsack, knapsackProblemSolution);

        }

        tsum += calculateTForSingleStep(lastCityIndex, firstCityIndex, knapsack, knapsackProblemSolution);


        return tsum;

    }

    private double calculateTForSingleStep(int fromCityIndex, int toCityIndex, Knapsack knapsack, KnapsackProblemSolution knapsackProblemSolution)
    {
        List<Item> itemsTaken = knapsackProblemSolution.getItemsForCity(fromCityIndex);
        if (itemsTaken != null) {
            knapsack.addItems(itemsTaken);
        }

        double distance = MathUtils.calculateDistanceBetweenTwoCities(problem.getCities().get(fromCityIndex - 1), problem.getCities().get(toCityIndex- 1));
        float vc = problem.getMaxSpeed() - knapsack.getCurrentWeight() * (problem.getMaxSpeed() - problem.getMinSpeed())/ knapsack.getCapacity();

        return distance/vc;
    }

    public KnapsackProblemSolution solveKnapsackProblemGreedy() {
        Knapsack knapsack = new Knapsack(problem.getKnapsackCapacity());
        List<Item> items = problem.getItemsGreedySorted();
        for (Item item : items) {
            knapsack.addItem(item);
        }
        return new KnapsackProblemSolution(knapsack.getItems());
    }
}
