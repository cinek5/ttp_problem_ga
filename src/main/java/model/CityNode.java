package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class CityNode {
    private int index;
    private float x;
    private float y;

    private List<Item> items;

    public CityNode(int index, float x, float y) {
        this.index = index;
        this.x = x;
        this.y = y;
        items = new ArrayList<Item>();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
