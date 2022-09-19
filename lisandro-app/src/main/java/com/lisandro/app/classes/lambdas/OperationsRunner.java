package com.lisandro.app.classes.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Creates a list of operations that can then be invoked.
public class OperationsRunner {
    private List<Operation> operations;
    private List<String> results;

    public OperationsRunner(List<String> inputStrings) {
        operations = new ArrayList<>();
        inputStrings.stream().forEach(this::createOperation); // For each input String create an operation.
    }

    // Creates an operation and adds it to the operations list.
    private void createOperation(String input) {
        String[] inputArr = input.split(" ");
        operations.add(Operation.builder()
                            .operationNum(Integer.parseInt(inputArr[0]))
                            .operationParam(Integer.parseInt(inputArr[1]))
                            .operationPerformer(Integer.parseInt(inputArr[0]))
                            .build());
    } 

    public void runOperations() {
        results = operations.stream().map(op -> op.execute()).collect(Collectors.toList());
    }

    /* Getters */
    public List<Operation> getOperations() {
        return operations;
    }

    public List<String> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return operations.toString();
    }
    
}
