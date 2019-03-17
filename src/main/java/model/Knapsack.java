package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class Knapsack {
    private List<Item> items;
    private int capacity;
    private int currentWeight;

    public Knapsack(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
        this.currentWeight = 0;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addItem(Item item)
    {
        if (item.getWeight() + currentWeight <= capacity )
        {
            items.add(item);
            currentWeight+=item.getWeight();
            return true;
        }
        return false;
    }

    public void addItems(List<Item> items)
    {
        for (Item item: items)
        {
            if (!addItem(item))
            {
                break;
            }
        }
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}
