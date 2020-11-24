package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class hashMap {
    public static void hashmap() {

       //Create
        Map<String, Integer> map = new HashMap<>();

        // Initialise
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        //Retrieve
        String str = "Three";
        if(map.containsKey(str)) {
            int num = map.get(str);
            System.out.println(num);
        } else {
            System.out.println("Not present");
        }

        //Iterate and Update

        Map result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        map.put(str, 7);

        //Delete

        boolean isRemoved = map.remove("Three", 3);
        System.out.print("Key value removed" + isRemoved);


    }
}
