package com.lisandro.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import com.lisandro.app.classes.lambdas.InputParser;

public class ParserTest {
    final String PATH = "src/test/java/com/lisandro/app/";

    @Test(expected = NullPointerException.class) // Tests that the parser throws a NullPointerException with non existent filepaths
    public void shouldThrowExceptionOnMissingFile() {
        InputParser parser = new InputParser(PATH + "resources/fake.txt"); // The operations that would trigger the exception are in the constructor
    }

    @Test
    public void shouldSkipWhiteSpaces() {
        InputParser parser = new InputParser(PATH + "resources/testinputwhitespace.txt");
        List<String> output = parser.getOutput();
        assertFalse(output.contains(" "));
    }

    @Test // Tests the case where a file will indicate 20 operations but contains less than that. parser should just operate with what was given.
    public void shouldReturnEvenWhenNotEnoughArguments() {
        InputParser parser = new InputParser(PATH + "resources/testinputnormal.txt");
        List<String> output = parser.getOutput();
        assertEquals(11, output.size());
    }
}
