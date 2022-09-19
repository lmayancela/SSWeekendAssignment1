package com.lisandro.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lisandro.app.classes.singleton.SampleSingleton;

public class SingletonTest {

    SampleSingleton singleton;
    SampleSingleton copysingleton1;
    SampleSingleton copysingleton2;

    @Before
    public void setup() {
        singleton = SampleSingleton.getInstance();
        copysingleton1 = SampleSingleton.getInstance();
        copysingleton2 = SampleSingleton.getInstance();
    }

    @Test
    // Tests if multiple references to singleton are referencing the same hash code.
    public void shouldBeSameHashCodeForMultipleSingleton()
    {   
        int hashcodeOriginal = singleton.hashCode();
        int hashcodeCopy1 = copysingleton1.hashCode();
        int hashcodeCopy2 = copysingleton2.hashCode();

        assertEquals(hashcodeOriginal, hashcodeCopy1);
        assertEquals(hashcodeOriginal, hashcodeCopy2);
    }

    @Test
    // Test if calling setters on one singleton variable alters the others.
    public void shouldShareStateAcrossVariables()
    {
        singleton.setName("Lisandro");

        assertEquals(singleton.getName(), copysingleton1.getName());

        copysingleton1.setText("I am a test Singleton");
        copysingleton2.setName("Taylor");

        assertEquals(copysingleton1.getText(), singleton.getText());
        assertEquals(copysingleton2.getName(), copysingleton1.getName());
    }
}
