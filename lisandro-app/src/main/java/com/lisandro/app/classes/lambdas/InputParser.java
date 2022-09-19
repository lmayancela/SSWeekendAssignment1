package com.lisandro.app.classes.lambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private int line, limit;
    private List<String> outputArr;
    private FileReader fr;

    public InputParser(String filename) {
        limit = 0;
        outputArr = new ArrayList<>();
        try{
            File f = new File(filename); // Find file
            fr = new FileReader(f);
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println(e);  // Print error if File isn't found, otherwise create FileReader object.
        } 
        readFile();
    }

    // Reads the file from the FileReader instance
    private void readFile() {
        line = -1;
        try{
            BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
            String next;            
            while((next = br.readLine()) != null && line < limit) //Read line by Line until the next line is null or the limit of operations is reached
            {
                handleInput(next);
            }
            br.close();
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    // Will ensure that each line, excluding the first one, gets added to the output array
    private void handleInput(String input) {
        if(line > -1) {
            if(!(input.equals(" "))){ //Add line to output if it isn't blank. Otherwise decriment line number to offset the increment at the end of this function.
                outputArr.add(input);
            } else {
                line--;
            }
        } else {
            limit = Integer.parseInt(input); // If it's the first line of the input, set it as the limit
        }
        line++;
    }

    /* Getters */
    public List<String> getOutput() {
        return outputArr;
    }
}
