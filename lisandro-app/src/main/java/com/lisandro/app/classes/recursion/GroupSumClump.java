package com.lisandro.app.classes.recursion;

import java.util.ArrayList;
import java.util.List;

public class GroupSumClump {
    private int target;
    private List<Cells> grouping;

    public GroupSumClump(int[] ints, int target) {
        this.target = target;
        grouping = Grouping.groupArr(ints);
    }

    public boolean startSumCheck() {
        return performSumCheck(new Accumulator(0), grouping);
    }

    /* Recursive Algorithm */
    private boolean performSumCheck(Accumulator accum, List<Cells> groupingReduced) {
        System.out.println(String.format("(accum: %d, currGroupings: %s)", accum.getAccum(), groupingReduced.toString()));
        BooleanChecker sumExists = new BooleanChecker(); // New Boolean tracker to keep check of this recursive call's results
        if(accum.getAccum() == target) {
            return true;
        } else {
            groupingReduced.stream().forEach(cell -> {
                if(!sumExists.getFlag()) { // only continue recursion if the flag isn't true;
                    List<Cells> groupingNew = new ArrayList<>(groupingReduced);
                    Accumulator newAccum = new Accumulator(accum.getAccum() + cell.getSum());
                    groupingNew.remove(cell);

                    if(performSumCheck(newAccum , groupingNew)) {
                        sumExists.setFlag(true);
                    }
                }
            });
        }
        return sumExists.getFlag();
    }
}
