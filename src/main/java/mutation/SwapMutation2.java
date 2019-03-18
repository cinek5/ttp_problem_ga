package mutation;

import model.Solution;
import utils.MathUtils;

import java.util.Collections;


/**
 * Created by Cinek on 18.03.2019.
 */
public class SwapMutation2 implements MutationOperator {
    @Override
    public Solution mutate(Solution solution) {
        int rand1 = MathUtils.randInt(0, solution.getCitiesIndexes().size());
        int rand2 = MathUtils.randInt(0, solution.getCitiesIndexes().size());
        Collections.swap(solution.getCitiesIndexes(), rand1, rand2);
        return solution;
    }
}
