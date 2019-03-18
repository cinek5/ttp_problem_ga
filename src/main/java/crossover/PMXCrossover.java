package crossover;

import model.Solution;
import utils.MathUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cinek on 17.03.2019.
 */
public class PMXCrossover implements  CrossoverOperator {
    @Override
    public Solution crossover(Solution parent1, Solution parent2) {
        int dimension = parent1.getDimension();
        int point1 = MathUtils.randInt(0, dimension);
        int point2 = MathUtils.randInt(0, dimension);

        Solution copy1 = parent1.getCopy();
        Solution copy2 = parent2.getCopy();



        int start = Math.min(point1,point2);
        int end = Math.max(point1, point2);

        Map<Integer, Integer> indexByValuesFor1 = new HashMap<>();
        Map<Integer, Integer> indexByValuesFor2 = new HashMap<>();

        for (int i=0; i<copy1.getDimension(); i++)
        {
            indexByValuesFor1.put(copy1.getCitiesIndexes().get(i), i);
            indexByValuesFor2.put(copy2.getCitiesIndexes().get(i), i);
        }

        for (int i=start; i<end; i++)
        {
            int help = copy1.getCitiesIndexes().get(i);
            copy1.getCitiesIndexes().set(i, copy2.getCitiesIndexes().get(i));
            copy2.getCitiesIndexes().set(i, help);
        }

        for (int i=start; i<end; i++)
        {
            int help  = copy1.getCitiesIndexes().get(i); //7
            int help2 = copy2.getCitiesIndexes().get(i); //4

            int index2 = indexByValuesFor2.get(help2);
            copy2.getCitiesIndexes().set(index2, help);

            int index1 = indexByValuesFor1.get(help);
            copy1.getCitiesIndexes().set(index1, help2);


        }




        return copy1;
    }
}
