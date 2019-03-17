package selection;

import model.Population;
import model.Solution;

/**
 * Created by Cinek on 17.03.2019.
 */
public interface SelectionStrategy {
    Solution selection(Population population);
}
