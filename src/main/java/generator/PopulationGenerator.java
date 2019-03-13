package generator;

import model.Population;
import model.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Cinek on 13.03.2019.
 */
public class PopulationGenerator {

    public static Population generatePopulation(int index, int numberOfSolutions, int dimension)
    {
        Set<Solution> solutions = new HashSet<>(numberOfSolutions);


        RandomSolutionGenerator randomSolutionGenerator = new RandomSolutionGenerator();

        while (solutions.size() != numberOfSolutions)
        {
            solutions.add(randomSolutionGenerator.generate(dimension));
        }


        return new Population(index, new ArrayList<>(solutions));
    }
    public static HashSet<List<Integer>> generatePopulationSet(int numberOfSolutions, int dimension)
    {
        RandomSolutionGenerator randomSolutionGenerator = new RandomSolutionGenerator();

        randomSolutionGenerator.generaterRandomList(dimension);
        HashSet<List<Integer>> solutions = new HashSet<>();

        while( solutions.size() != numberOfSolutions)
        {
            solutions.add(randomSolutionGenerator.generaterRandomList(dimension));
        }
        return solutions;
    }
}
