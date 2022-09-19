package com.lisandro.app.classes.functionals;

import java.util.List;
import java.util.stream.Collectors;

public class Functionals {
    public static List<Integer> rightDigit(List<Integer> list) {
        return list.stream().map(i -> i % 10).collect(Collectors.toList());
    }

    public static List<Integer> doubling(List<Integer> list) {
        return list.stream().map(i -> i * 2).collect(Collectors.toList());
    }

    public static List<String> noX(List<String> list) {
        return list.stream().map(Functionals::filter).collect(Collectors.toList());
    }

    private static String filter(String s) {
        return s.toLowerCase().replaceAll("x", "");
    }
}
