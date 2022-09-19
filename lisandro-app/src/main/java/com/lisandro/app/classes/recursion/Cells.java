package com.lisandro.app.classes.recursion;

import java.util.ArrayList;
import java.util.List;

public class Cells {
    private int sum; // Sum of the cell

    private List<Integer> nums; // Numbers in the cell

    public Cells(int initial) {
        nums = new ArrayList<>();
        nums.add(initial);
        sum += initial;
    }

    public void addToCell(int num) {
        nums.add(num);
        sum += num;
    }

    public String toString() {
        return String.format("(Sum: %d, Nums: %s)", sum, nums.toString());
    }

    /* Getters */
    public List<Integer> getNums() {
        return nums;
    }

    public int getSum() {
        return sum;
    }
    
}
