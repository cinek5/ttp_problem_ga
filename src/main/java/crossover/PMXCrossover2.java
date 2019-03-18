package crossover;

import model.Solution;
import utils.MathUtils;
import utils.RandomGenerator;

import java.util.*;

/**
 * Created by Cinek on 17.03.2019.
 */
public class PMXCrossover2 implements  CrossoverOperator {

    private RandomGenerator randomGenerator;

    public PMXCrossover2(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Solution crossover(Solution parent1, Solution parent2) {

        int dimension = parent1.getDimension();
        int point1 = randomGenerator.randInt(0, dimension);
        int point2 = randomGenerator.randInt(0, dimension);

        Solution child = generateEmptySolution(dimension);


        int start = Math.min(point1,point2);
        int end = Math.max(point1, point2);

        Map<Integer, Integer> indexByValuesFor1 = new HashMap<>();
        Map<Integer, Integer> indexByValuesFor2 = new HashMap<>();
        for (int i=0; i<dimension; i++)
        {
            indexByValuesFor1.put(parent1.getCitiesIndexes().get(i), i);
            indexByValuesFor2.put(parent2.getCitiesIndexes().get(i), i);
        }


        HashSet<Integer> valuesCopiedToChild = new HashSet<>(end-start);

        for (int i=start; i<end; i++)
        {
            int help = parent1.getCitiesIndexes().get(i);
            child.getCitiesIndexes().set(i, help);
            valuesCopiedToChild.add(help);
        }



        List<Integer> valuesThatHasntBeenCopied = new ArrayList<>();
        for (int i=start; i<end; i++)
        {
            int value  = parent2.getCitiesIndexes().get(i);
            if (!valuesCopiedToChild.contains(value))
            {
                valuesThatHasntBeenCopied.add(value);
            }
        }


        for (Integer i : valuesThatHasntBeenCopied )
        {
            int index2 = -1;
            int index = -1;
            int V = i;
            while(true)
            {
                 index = indexByValuesFor2.get(V);
                 V = parent1.getCitiesIndexes().get(index);
                 index2 = indexByValuesFor2.get(V);

                 if (index2<start || index2>=end)
                 {
                     child.getCitiesIndexes().set(index2, i);
                     break;
                 }


            }




        }

        for (int i=0; i<dimension; i++)
        {
            int cityIndex = child.getCitiesIndexes().get(i);
            if (cityIndex==0)
            {
                child.getCitiesIndexes().set(i, parent2.getCitiesIndexes().get(i));
            }
        }





        return child;
    }

    private Solution generateEmptySolution(int dimension) {

        List<Integer> list = new ArrayList<>(dimension);
        for (int i=0; i<dimension; i++)
        {
            list.add(0);
        }
        Solution solution = new Solution(dimension, list );
        return solution;
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
}
