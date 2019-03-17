package model;

import java.util.List;

/**
 * Created by Cinek on 10.03.2019.
 */
public class Solution {
    private int dimension;
    private List<Integer> citiesIndexes;
    private double fitness;

    public Solution(int dimension, List<Integer> citiesIndexes) {
        this.dimension = dimension;
        this.citiesIndexes = citiesIndexes;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
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

    @Override
    public int hashCode() {
        return citiesIndexes.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        return citiesIndexes.equals(solution.citiesIndexes);
    }
}
