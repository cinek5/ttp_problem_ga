package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cinek on 10.03.2019.
 */
public class KnapsackProblemSolution {
    private Map<Integer, List<Item>> itemsTakenByCityIndex;
    private double knapsackValue;

    public KnapsackProblemSolution(List<Item> itemsTaken) {
        itemsTakenByCityIndex = createItemsTakenByCityIndexMap(itemsTaken);
        knapsackValue = computeKnapsackValue(itemsTaken);

    }

    public double getKnapsackValue() {
        return knapsackValue;
    }

    private double computeKnapsackValue(List<Item> items)
    {
        double sum = 0;
        for (Item item : items)
        {
            sum += item.getProfit();
        }
        return sum;
    }


    private Map<Integer, List<Item>> createItemsTakenByCityIndexMap(List<Item> itemsTaken)
    {
        itemsTakenByCityIndex = new HashMap<>();
        for (Item item : itemsTaken )
        {
            int cityIndex = item.getCityIndex();
            if (itemsTakenByCityIndex.get(cityIndex) == null)
            {
                List<Item> items = new ArrayList<>();
                items.add(item);
                itemsTakenByCityIndex.put(cityIndex, items);
            }
            else
            {
                itemsTakenByCityIndex.get(cityIndex).add(item);
            }
        }
        return itemsTakenByCityIndex;
    }
    public List<Item> getItemsForCity(int cityIndex)
    {
        return itemsTakenByCityIndex.get(cityIndex);
    }
}
