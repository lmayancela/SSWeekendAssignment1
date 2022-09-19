package com.lisandro.app.classes;

// Class for a singleton with double checked locking
public class SampleSingleton {
    private static SampleSingleton instance; // Private variable holding single instance of singleton

    private String name;
    private String text;

    public synchronized static SampleSingleton getInstance() { // This synchronized keyword locks the method.
        if (instance == null) { // Check if there isb't already an instance.
            synchronized(SampleSingleton.class) { // If there isn't an instance then we lock the class before we create one.
                if (instance == null) { // Check for null again in case another thread already created instance between locking the method and class.
                    instance = new SampleSingleton(); // Set instance
                }
            }
            
        }
        return instance; // Return instance
    } 

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    // Synchronized setters so we can avoid multiple threads manupulating the Singleton at the same time
    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized void setText(String text) {
        this.text = text;
    }

    private SampleSingleton(){}

}