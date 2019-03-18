package selection;

import config.Config;
import model.Population;
import model.Solution;
import problem.GeneticAlgorithm;
import utils.MathUtils;

import java.util.HashSet;

/**
 * Created by Cinek on 18.03.2019.
 */
public class TournamentSelectionStrategy implements SelectionStrategy {
    @Override
    public Solution selection(Population population) {
        HashSet<Integer> indices =  new HashSet<>(Config.TOUR);
        while (indices.size() != Config.TOUR)
        {
            indices.add(MathUtils.randInt(0, population.getSolutions().size()));
        }
        Solution best = null;
        for (Integer i : indices)
        {
            Solution solution = population.getSolutions().get(i);
            if (best == null)
            {
                best = solution;
            }
            else
            {
                if (solution.getFitness() > best.getFitness())
                {
                    best = solution;
                }
            }
        }

        return best;
    }
}
