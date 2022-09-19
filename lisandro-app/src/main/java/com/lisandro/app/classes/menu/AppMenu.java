package com.lisandro.app.classes.menu;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AppMenu {
    private Scanner scanner;
    private boolean running;
    private final String intro = "Welcome to Weekend Assignment 1 \n Menu: \n 1) Lambdas \n 2) Functional \n 3) Recursion \n 4) Singleton \n\n";

    public AppMenu() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        running = true;
        System.out.println(intro);
        String input;
        while(running) {
            input = read();
            if(validate(input)) {
                switch(input) {
                    case "q": running = false; break;
                    default: execute(input);
                }
            } else {
                System.out.println("Not a supported option. Please try again");
            }
        }
        scanner.close();
        exit();
    }

    private String read() {
        System.out.println("Select one (1-4) to continue or enter 'q' to exit: \n");
        return scanner.nextLine();
    }

    private boolean validate(String input) {
        if (input.equals("q")) {
            return true;
        } else {
            try{ // We wrap this in a try catch for case that input is not q but some other non numeric number. This will result in parseInt method throwing an error
                int num = Integer.parseInt(input);
                boolean outRange = IntStream.range(1, 5).noneMatch(i -> num == i);
                if(!outRange) { return true; }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private void execute(String input) {
        System.out.println("\nExecuting " + input + "\n");
        MenuExecutor.execute(Integer.parseInt(input));
        System.out.println("\n");
    }

    private void exit() {
        System.out.println("Goodbye");
    }
}
