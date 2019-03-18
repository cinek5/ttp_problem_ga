package crossover;

import model.Solution;

/**
 * Created by Cinek on 17.03.2019.
 */
public interface CrossoverOperator {
    Solution crossover(Solution parent1, Solution parent2);
}
