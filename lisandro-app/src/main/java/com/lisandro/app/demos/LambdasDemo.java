package com.lisandro.app.demos;

import java.util.List;

import com.lisandro.app.classes.lambdas.InputParser;
import com.lisandro.app.classes.lambdas.OperationsRunner;

public class LambdasDemo {
    final static String PATH = "SSWeekendAssignment1/lisandro-app/src/main/java/com/lisandro/app/";
    public static void run() {

        System.out.println("Results of input.txt");
        InputParser parser = new InputParser(PATH + "resources/input.txt");
        OperationsRunner runner = new OperationsRunner(parser.getOutput());
        runner.runOperations();
        List<String> results = runner.getResults();
        results.stream().map(operation -> operation.toString()).forEach(System.out::println);

    }
}
