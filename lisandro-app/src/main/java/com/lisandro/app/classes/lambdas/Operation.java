package com.lisandro.app.classes.lambdas;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import com.lisandro.app.interfaces.PerformOperation;
import com.lisandro.app.interfaces.PerformOperation.ShowOperation;

public class Operation {
    private final int operationNum, operationParam;
    private final PerformOperation performer; // Object that will perform the operation.
    private final ShowOperation shower;

    public static OperationBuilder builder() {
        return new OperationBuilder();
    }

    protected Operation(int operationNum, int operationParam, PerformOperation performer, ShowOperation shower) {
        this.operationNum = operationNum;
        this.operationParam = operationParam;
        this.performer = performer;
        this.shower = shower;
    }

    public String execute() {
        return shower.result(performer.perform(operationParam));
    }

    /* Getters */
    public int getOperationParam() {
        return operationParam;
    }

    public int getOperationNum() {
        return operationNum;
    }
    
    // Static Builder class for an Operation object.
    public static class OperationBuilder {
        private int operationNum, operationParam;
        private PerformOperation performer;
        private ShowOperation shower;

        public OperationBuilder operationNum(int num) {
            this.operationNum = num;
            return this;
        }

        public OperationBuilder operationParam(int param) {
            this.operationParam = param;
            return this;
        }

        public OperationBuilder operationPerformer(int num) {
            createPerformer(num);
            return this;
        }

        // Using the operation number, create and set value of the performer interface.
        private void createPerformer(int operation) {
            // Here are the lambdas for the specified operations in the assignment
            switch(operation) {
                case 1: //isOdd
                    //Create Performer
                    performer = num -> num % 2 > 0;

                    //Create Shower
                    shower = PerformOperation.showOne();
                    break;
                case 2: //isPrime
                    //Create Performer
                    performer = num -> {
                        IntPredicate isDivisible = index -> num % index == 0;
                        return (num > 1 && IntStream.range(2, num - 1).noneMatch(isDivisible));
                    };

                    //Create Shower
                    shower = PerformOperation.showTwo();
                    break;
                case 3: //isPalindrome
                    //Create Performer
                    performer = num -> {
                        String tempString = String.valueOf(num); //Turn the given number to a string
                        return IntStream.range(0, tempString.length()/2)
                                    .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));
                    };

                    //Create Shower
                    shower = PerformOperation.showThree();
                    break;
            }
        }
        
        public Operation build() {
            return new Operation(operationNum,operationParam,performer,shower);
        }
    }
}
