package problem;

import loader.Loader;
import model.Item;
import model.Knapsack;
import model.KnapsackProblemSolution;
import model.Solution;
import model.comparators.HigherProfitWeightRatioComparator;
import utils.MathUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class GeneticAlgorithm {

    private Problem problem;

    public GeneticAlgorithm(Problem problem)
    {
        this.problem = problem;
    }

    public static void main(String[] args) {
        Loader loader = new Loader();
        Problem problem = null;
        try {
            problem = loader.loadProblemData("C:\\Users\\Cinek\\Documents\\projektyJAVA\\ttp_problem_ga\\src\\main\\resources\\trivial_0.ttp");
            System.out.println("problem data loaded");
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(problem);



        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

    public double functionF(Solution solution) {
        KnapsackProblemSolution knapsackProblemSolution = solveKnapsackProblemGreedy(solution);
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
        knapsack.addItems(itemsTaken);

        double distance = MathUtils.calculateDistanceBetweenTwoCities(problem.getCities().get(fromCityIndex - 1), problem.getCities().get(toCityIndex- 1));
        float vc = problem.getMaxSpeed() - knapsack.getCurrentWeight() * (problem.getMaxSpeed() - problem.getMinSpeed())/ knapsack.getCapacity();

        return distance/vc;
    }

    public KnapsackProblemSolution solveKnapsackProblemGreedy(Solution solution) {
        Knapsack knapsack = new Knapsack(problem.getKnapsackCapacity());
        List<Item> items = problem.getItemsInCities(solution);
        Collections.sort(items, new HigherProfitWeightRatioComparator());
        for (Item item : items) {
            knapsack.addItem(item);
        }
        return new KnapsackProblemSolution(knapsack.getItems());
    }
}
