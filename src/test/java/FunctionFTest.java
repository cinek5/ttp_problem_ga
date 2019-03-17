import model.CityNode;
import model.Item;
import model.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import problem.GeneticAlgorithm;
import problem.Problem;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by Cinek on 13.03.2019.
 */
@RunWith(JUnit4.class)
public class FunctionFTest {
    @Test
    public void test_FunctionF_Is_Calculated_Properly()
    {
        Item item1 = new Item(1, 20, 10, 1);
        Item item2 = new Item(2, 10, 10, 2);
        Item item3 = new Item(3,30, 10, 3);
        CityNode cityNode1 = new CityNode(1, 1, 1);
        cityNode1.addItem(item1);
        CityNode cityNode2 = new CityNode(2, 5,4);
        cityNode2.addItem(item2);
        CityNode cityNode3 = new CityNode(3, 8, 2);
        cityNode3.addItem(item3);

        Problem problem = new Problem(asList(cityNode1, cityNode2, cityNode3), 3 , 3, 0.1f, 1 , 25,
                asList(item1, item2, item3));

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(problem);
        Solution solution = new Solution(3, asList(1,2,3));
        double calculatedF = geneticAlgorithm.functionF(solution);

        assertEquals(38.70, calculatedF, 0.01);

    }
}
