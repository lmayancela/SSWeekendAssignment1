package com.lisandro.app;

import com.lisandro.app.classes.menu.AppMenu;

/**
 * Invokes AppMenu to begin the App.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AppMenu menu = new AppMenu();
        menu.start();
    }
}