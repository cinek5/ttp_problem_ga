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

        double minFitness =  minFitness(population);
        double sumOfFitness = sumOfFitness(population, minFitness);
        double rand = MathUtils.randDouble(0, sumOfFitness);

        float partialSum = 0;
        for (Solution solution : population.getSolutions() )
        {
            double fitness =solution.getFitness() - minFitness;
            partialSum+= fitness;
            if (partialSum>=rand)
            {
                return solution;
            }
        }
        return null;
    }

    private double minFitness(Population population)
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



    private double sumOfFitness(Population population, double minFitness)
    {
        double sum = 0;
        for (Solution solution : population.getSolutions() )
        {
            sum+=(solution.getFitness() - minFitness);
        }
        return sum;
    }
}
