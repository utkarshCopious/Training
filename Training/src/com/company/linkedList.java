package com.company;

import java.util.*;

public class linkedList {
    public static void linkedlist() {

        //Creation
        LinkedList<String> str = new LinkedList<>();

        //Initialize
        str.add("Rajeev");
        str.add("John");
        str.add("David");
        str.add("Chris");

        //Retrieve

        String firstname = str.getFirst();
        String lastname = str.getLast();
        String customname = str.get(3);



        //sorting and iterating
        str.forEach(name -> {
            System.out.println(name);
        });

        Collections.sort(str, new Comparator<String>() {

            @Override public int compare(String s1, String s2)
            { return s1.length() - s2.length();
            } } );



        //Delete

        String del = str.removeFirst();
        String dellast = str.removeLast();
        del = str.remove(3);



    }
}
