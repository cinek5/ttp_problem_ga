package model;

import java.util.List;

/**
 * Created by Cinek on 13.03.2019.
 */
public class Population {
    private int index;
    List<Solution> solutions;

    public Population(int index, List<Solution> solutions) {
        this.index = index;
        this.solutions = solutions;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}
