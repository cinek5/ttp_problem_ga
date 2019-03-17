package selection;

import model.Population;
import model.Solution;
import utils.MathUtils;

import java.util.List;

/**
 * Created by Cinek on 17.03.2019.
 */
public class RouletteSelectionStrategy implements SelectionStrategy {
    @Override
    public Solution selection(Population population) {

        double sumOfFitness = sumOfFitness(population);
        double rand = MathUtils.randDouble(0, sumOfFitness);
        float partialSum = 0;
        for (Solution solution : population.getSolutions() )
        {
            partialSum+= solution.getFitness();
            if (partialSum>=rand)
            {
                return solution;
            }
        }
        return null;
    }

    private double sumOfFitness(Population population)
    {
        double sum = 0;
        for (Solution solution : population.getSolutions() )
        {
            sum+=solution.getFitness();
        }
        return sum;
    }
}
