import crossover.PMXCrossover;
import model.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.util.Arrays.asList;

/**
 * Created by Cinek on 18.03.2019.
 */
@RunWith(JUnit4.class)
public class PMXCrossoverTest {
    @Test
    public void test_PMX_Crossover()
    {
        PMXCrossover pmxCrossover = new PMXCrossover();
        Solution solution1 = new Solution(8, asList(1,2,3,4,5,6,7,8));
        Solution solution2 = new Solution( 8, asList(4,3,2,7,6,5,8,1));

        Solution result = pmxCrossover.crossover(solution1, solution2);

        System.out.println(result.getCitiesIndexes());
    }

}
