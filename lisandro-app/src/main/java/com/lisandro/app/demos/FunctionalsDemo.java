package com.lisandro.app.demos;

import java.util.ArrayList;
import java.util.List;

import com.lisandro.app.classes.functionals.Functionals;

public class FunctionalsDemo {
    public static void run() {
        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(121);
        ints.add(11);
        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("xxbx");
        strings.add("hxexxllox");
        strings.add("xtestx");
        strings.add("XD3athMinionX");
        strings.add("x");
        List<Integer> results1 = Functionals.rightDigit(ints);
        List<Integer> results2 = Functionals.doubling(ints);
        List<String> results3 = Functionals.noX(strings);
        System.out.println(results1.toString());
        System.out.println(results2.toString());
        System.out.println(results3.toString());
    }
}
