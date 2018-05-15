package com.mohit.program.hashmap;

import java.util.*;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class HashMapMaster {

    public HashMapMaster() {

        // creating hash objects
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> has = new HashMap<String, ArrayList<String>>();

        // inserting value into hash	
        hash.put("Indore", new Integer(1));
        hash.put("Ujjain", new Integer(2));

        // return true id value contains key	
        System.out.println(hash.containsValue(1));

        // creating array list	
        ArrayList<String> name = new ArrayList<String>();
        name.add("mohit");
        name.add("soni");

        ArrayList<String> age = new ArrayList<String>();
        age.add("23");
        age.add("24");

        // inserting array list to hash	
        has.put("age", age);
        has.put("name", name);

        // get entry set for hash	
        Set<Map.Entry<String, ArrayList<String>>> id = has.entrySet();
        System.out.println(id);

        // create iterator to hash key 	
        Iterator<Map.Entry<String, ArrayList<String>>> it = id.iterator();

        // loop to display
        while (it.hasNext()) {
            // get map of hash key	
            Map.Entry<String, ArrayList<String>> map = it.next();
            // get string of key	
            String key = map.getKey();
            // get list associate to list
            List<String> li = map.getValue();
            // print  it
            System.out.println(key + ":" + li);
        }
    }
}
