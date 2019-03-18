import crossover.PMXCrossover2;
import model.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.RandomGenerator;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Cinek on 18.03.2019.
 */
@RunWith(JUnit4.class)
public class PMXCrossover2Test {
    @Test
    public void test_PMXCrossover2()
    {
        RandomGenerator randomGenerator = new RandomGeneratorMock();
        PMXCrossover2 pmxCrossover2 = new PMXCrossover2(randomGenerator);
        Solution parent1 = new Solution(10, asList(9,5,8,4,7,3,6,2,10,1));
        Solution parent2 = new Solution(10, asList(1,2,3,4,5,6,7,8,9,10));
        Solution result = pmxCrossover2.crossover(parent1, parent2);

        assertEquals(asList(1,8,5,4,7,3,6,2,9,10), result.getCitiesIndexes());
    }






    static class RandomGeneratorMock extends RandomGenerator
    {
        int count = 0;
        @Override
        public double randDouble(double min, double max) {
            return super.randDouble(min, max);
        }

        @Override
        public int randInt(int min, int max) {
            if (count == 0)
            {
                count++;
                return 3;
            }
            return 8;
        }
    }
}
