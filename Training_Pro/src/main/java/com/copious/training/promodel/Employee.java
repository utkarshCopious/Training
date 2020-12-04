package com.copious.training.promodel;

/**
 * @author Utkarsh Awasthi
 **/

public class Employee {

    private String id;
    private String name;
    private String description;

    /**
     *
     * Private constructor for Singleton Implementation
     */

    //private Employee() {}

    public Employee(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     *
     * Thread safe with Double checked locking  - Singleton Implementation
     */
//    public static Employee getInstance(){
//        if(obj == null){
//            synchronized (Employee.class) {
//                if(obj == null){
//                    obj = new Employee();
//                }
//            }
//        }
//        return obj;
//    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int compareTo(Employee employee) {
        return 0;
    }
}
