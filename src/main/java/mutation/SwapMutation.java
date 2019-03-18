package mutation;

import config.Config;
import model.Solution;
import utils.MathUtils;

import java.util.Collections;

/**
 * Created by Cinek on 18.03.2019.
 */
public class SwapMutation implements MutationOperator {
    @Override
    public Solution mutate(Solution solution) {

        for (int i=0; i<solution.getCitiesIndexes().size(); i++)
        {
            double rand = Math.random();
            if (rand<= Config.MUTATION_PROB)
            {
                int randomIndex = MathUtils.randInt(0, solution.getCitiesIndexes().size());
                Collections.swap(solution.getCitiesIndexes(), i, randomIndex );
            }
        }


        return solution;
    }
}
