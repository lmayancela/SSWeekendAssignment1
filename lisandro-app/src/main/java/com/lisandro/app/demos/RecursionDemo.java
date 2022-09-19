package com.lisandro.app.demos;

import com.lisandro.app.classes.recursion.GroupSumClump;

public class RecursionDemo {
    public static void run() {

        int[] ints = new int[]{1,1,2,3,3,2,4,5,4,4};
        // int[] ints = new int[]{1,2,2,2,5,2};
        //int[] ints = new int[]{2,4,4,8};

        GroupSumClump gsc = new GroupSumClump(ints, 12);

        if(gsc.startSumCheck()) {
            System.out.println("\nTrue");
        } else {
            System.out.println("\nFalse");
        }
        
    }
}
