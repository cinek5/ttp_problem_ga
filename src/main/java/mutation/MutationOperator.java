package mutation;

import model.Solution;

/**
 * Created by Cinek on 18.03.2019.
 */
public interface MutationOperator {
    Solution mutate(Solution solution);
}
