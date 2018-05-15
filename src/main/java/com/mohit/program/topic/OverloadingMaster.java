package com.mohit.program.topic;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class OverloadingMaster {

    public OverloadingMaster() {
        Collection<String> c = new HashSet<String>(); // c is object of HashSet but of type  Collection
        OverloadingMaster o = new OverloadingMaster();
        o.sort(c);
    }


    /**
     * overloading
     *
     * @param c
     * @return
     */
    public Collection<String> sort(Collection<String> c) {
        System.out.println("Inside Collection sort method");
        return c;
    }


    public Collection<String> sort(HashSet<String> c) {
        System.out.println("Inside HashSet sort method");
        return c;
    }
}
