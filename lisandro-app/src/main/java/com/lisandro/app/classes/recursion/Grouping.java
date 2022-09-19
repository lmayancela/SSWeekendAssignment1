package com.lisandro.app.classes.recursion;

import java.util.ArrayList;
import java.util.List;

public class Grouping {
    public static List<Cells> groupArr(int[] initial) {
        Integer prev = null;
        Cells prevCell = null;
        List<Cells> grouped = new ArrayList<>();
        for(int i : initial) {
            if (prev == null) {
                prev = i;
                prevCell = new Cells(i);
                grouped.add(prevCell);
            } else {
                if (i == prev) {
                    prevCell.addToCell(i);
                } else {
                    prev = i;
                    prevCell = new Cells(i);
                    grouped.add(prevCell);
                }
            }
        }
        return grouped;
    }
}
