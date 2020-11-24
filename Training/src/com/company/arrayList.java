package com.company;

import java.util.*;

public class arrayList {

    public static void arraylist() {
        List<Integer> ffs = new ArrayList<>();


        //add element
        ffs.add(1);
        ffs.add(5);
        ffs.add(3);
        ffs.add(8);

        System.out.println(ffs);

        //delete element

        ffs.remove(3);

        //iterate

        ffs.forEach( list -> { System.out.println(ffs); });

        // Sorting

        Collections.sort(ffs);

        //sort using comparator

        ffs.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

    }
}
