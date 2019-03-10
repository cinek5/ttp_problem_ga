package model;

/**
 * Created by Cinek on 10.03.2019.
 */
public class Item {
    private int index;
    private int profit;
    private int weight;
    private int cityIndex;

    public Item(int index, int profit, int weight, int cityIndex) {
        this.index = index;
        this.profit = profit;
        this.weight = weight;
        this.cityIndex = cityIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCityIndex() {
        return cityIndex;
    }

    public void setCityIndex(int cityIndex) {
        this.cityIndex = cityIndex;
    }
}
