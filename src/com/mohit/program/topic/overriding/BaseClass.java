package com.mohit.program.topic.overriding;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class BaseClass extends SuperClass{

    @Override
    public void start(int a) {
       // calling method from super class
        super.start(a);
    }
}
