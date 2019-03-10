package model;

import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class Solution {
    private int dimension;
    private List<Integer> citiesIndexes;

    public Solution(int dimension, List<Integer> citiesIndexes) {
        this.dimension = dimension;
        this.citiesIndexes = citiesIndexes;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<Integer> getCitiesIndexes() {
        return citiesIndexes;
    }

    public void setCitiesIndexes(List<Integer> citiesIndexes) {
        this.citiesIndexes = citiesIndexes;
    }
}
