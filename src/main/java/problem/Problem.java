package problem;

import model.CityNode;
import model.Item;
import model.Knapsack;
import model.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class Problem {
    private List<CityNode> cities;
    private List<Item> allItems;
    private int knapsackCapacity;
    private int dimension;
    private int numberOfItems;
    private float minSpeed;
    private float maxSpeed;

    public Problem(List<CityNode> cities, int dimension, int numberOfItems, float minSpeed, float maxSpeed, int knapsackCapacity, List<Item> allItems) {
        this.cities = cities;
        this.dimension = dimension;
        this.numberOfItems = numberOfItems;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.knapsackCapacity = knapsackCapacity;
        this.allItems = allItems;
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }

    public List<CityNode> getCities() {
        return cities;
    }

    public void setCities(List<CityNode> cities) {
        this.cities = cities;
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public void setKnapsackCapacity(int knapsackCapacity) {
        this.knapsackCapacity = knapsackCapacity;
    }

    public List<Item> getItemsInCities(Solution solution)
    {
        List<Item> items = new ArrayList<>();
        for(Integer cityIndex: solution.getCitiesIndexes() )
        {
            items.addAll(cities.get(cityIndex-1).getItems());
        }
        return items;

    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public float getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(float minSpeed) {
        this.minSpeed = minSpeed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
