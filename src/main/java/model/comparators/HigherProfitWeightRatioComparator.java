package model.comparators;

import model.Item;

import java.util.Comparator;

/**
 * Created by Cinek on 10.03.2019.
 */
public class HigherProfitWeightRatioComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        float o2ratio = o2.getProfit()/ o2.getWeight();
        float o1ratio = o1.getProfit()/ o1.getWeight();
        return Float.compare(o2ratio, o1ratio);
    }
}
