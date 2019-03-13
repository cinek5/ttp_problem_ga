package generator;

import model.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class RandomSolutionGenerator {

    public List<Integer> generaterRandomList(int dimension)
    {
        List<Integer> baseList = generateBaseList(dimension);
        Collections.shuffle(baseList);
        return baseList;

    }
    public Solution generate(int dimension)
    {
        List<Integer>  baseList = generateBaseList(dimension);

        Collections.shuffle(baseList);

        return new Solution(dimension, baseList);
    }

    private List<Integer> generateBaseList(int dimension)
    {
        List<Integer> baseList = new ArrayList<>(dimension);
        for (int i=1; i<=dimension; i++)
        {
            baseList.add(i);
        }
        return baseList;
    }
}
