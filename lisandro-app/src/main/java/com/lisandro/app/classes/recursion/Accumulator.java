package com.lisandro.app.classes.recursion;

public class Accumulator {
    private int accum;

    public Accumulator(int initial) {
        accum = initial;
    }

    // Increases state accum by int i
    public void accumulate(int i) {
        accum += i;
    }

    public int getAccum() {
        return accum;
    }
}
