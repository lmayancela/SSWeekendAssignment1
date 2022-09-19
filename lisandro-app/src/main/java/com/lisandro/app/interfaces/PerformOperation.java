package com.lisandro.app.interfaces;

@FunctionalInterface
public interface PerformOperation {
    boolean perform(int x);

    // Static methods which return a defined functional interface for each of the operations result statements.
    public static ShowOperation showOne() {  
        return new ShowOperation() {
            @Override
            public String result(boolean b) {
                if(b) {
                    return "ODD";
                } else {
                    return "EVEN";
                }
            }
        };
    }

    public static ShowOperation showTwo() {
        return new ShowOperation() {
            @Override
            public String result(boolean b) {
                if(b) {
                    return "PRIME";
                } else {
                    return "COMPOSITE";
                }
            }
        };
    }

    public static ShowOperation showThree() {
        return new ShowOperation() {
            @Override
            public String result(boolean b) {
                if(b) {
                    return "PALINDROME";
                } else {
                    return "NOT PALINDROME";
                }
            }
        };
    }

    @FunctionalInterface
    public interface ShowOperation {
        String result(boolean b);
    }
}
