package com.lisandro.app.classes.menu;

import com.lisandro.app.demos.FunctionalsDemo;
import com.lisandro.app.demos.LambdasDemo;
import com.lisandro.app.demos.RecursionDemo;
import com.lisandro.app.demos.SingletonDemo;

public class MenuExecutor {
    public static void execute(int projectNum) {
        switch(projectNum) {
            case 1: LambdasDemo.run(); break;
            case 2: FunctionalsDemo.run(); break;
            case 3: RecursionDemo.run(); break;
            case 4: SingletonDemo.run(); break;
        }
    }
}
