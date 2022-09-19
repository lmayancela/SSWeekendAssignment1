package com.lisandro.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lisandro.app.classes.InputParser;
import com.lisandro.app.classes.Operation;
import com.lisandro.app.classes.OperationsRunner;

// Test for both the Operation and OperationsRunner classes.
public class OperationsTest {
    OperationsRunner runner;

    @Before
    public void setup() {
        InputParser parser = new InputParser("src/test/java/com/lisandro/app/resources/testinputnormal.txt");
        runner = new OperationsRunner(parser.getOutput());
    }

    @Test
    public void isEvenShouldReturnProperly() {
        Operation op1 = Operation.builder()
                            .operationNum(1)
                            .operationParam(4)
                            .operationPerformer(1)
                            .build();
        
        Operation op2 = Operation.builder()
                            .operationNum(1)
                            .operationParam(3)
                            .operationPerformer(1)
                            .build();

        String resulttrue = op1.execute();
        String resultfalse = op2.execute();

        assertEquals("EVEN", resulttrue);
        assertEquals("ODD", resultfalse);
    }

    @Test
    public void isPrimeShoudldReturnProperly() {
        Operation op1 = Operation.builder()
                            .operationNum(2)
                            .operationParam(7)
                            .operationPerformer(2)
                            .build();
        
        Operation op2 = Operation.builder()
                            .operationNum(2)
                            .operationParam(1)
                            .operationPerformer(2)
                            .build();
        
        String resulttrue = op1.execute();
        String resultfalse = op2.execute();

        assertEquals("PRIME", resulttrue);
        assertEquals("COMPOSITE", resultfalse);
    }

    @Test
    public void isPalindromeShouldReturnProperly() {
        Operation op1 = Operation.builder()
                            .operationNum(3)
                            .operationParam(23532)
                            .operationPerformer(3)
                            .build();
        
        Operation op2 = Operation.builder()
                            .operationNum(3)
                            .operationParam(23731)
                            .operationPerformer(3)
                            .build();
        
        String resulttrue = op1.execute();
        String resultfalse = op2.execute();

        assertEquals("PALINDROME", resulttrue);
        assertEquals("NOT PALINDROME", resultfalse);
    }

    @Test
    public void runnerShouldReturnCorrectNumberOfExecutedOperations() {
        runner.runOperations();
        List<String> results = runner.getResults();
        assertEquals(11, results.size());
    }
}
