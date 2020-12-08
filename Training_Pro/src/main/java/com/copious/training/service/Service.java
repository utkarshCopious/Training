package com.copious.training.service;

import com.copious.training.promodel.Employee;
import com.training.exceptions.exceptions.CommonException;
import com.training.exceptions.exceptions.EmployeeNotFoundException;
import com.training.exceptions.exceptions.NothingToAddException;
import com.training.exceptions.exceptions.ProcessRuntimeErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Utkarsh Awasthi
 */

@org.springframework.stereotype.Service
public class Service {
    //Data Set
    private final List<Employee> employeeList = new ArrayList<>(Arrays.asList(

            new Employee("12", "Jhon", "Manager"),
            new Employee("15", "copious", "employee"),
            new Employee("17", "discovery", "client"),
            new Employee("20", "Akhand", "Mentor"),
            new Employee("22", "Aman", "employee"),
            new Employee("25", "Draco", "client")

    ));

//        employeeList.forEach( list -> { System.out.println(employeeList); });


    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee getEmployee(String id) {
        return employeeList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public List<Employee> sortEmployee() {
        try {
            employeeList.sort((e1, e2) -> e2.compareTo(e1));

        } catch (IndexOutOfBoundsException | ProcessRuntimeErrorException e) {
            e.printStackTrace();
            throw new ProcessRuntimeErrorException();
        }
        return employeeList;
    }


    public List<Employee> addEmployee(Employee employe) throws NothingToAddException {
        try {
            employeeList.add(employe);

        } catch (NothingToAddException e) {
            throw new NothingToAddException();
        }
        return employeeList;
    }


    public void updateEmployee(Employee employe, String id) {
        int counter = 0;
        try {
            for (Employee employee1 : employeeList) {
                if (employee1.getId().equals(id)) {
                    employeeList.set(counter, employe);
                }
                counter++;
            }
        } catch (EmployeeNotFoundException | ProcessRuntimeErrorException error) {
            throw new EmployeeNotFoundException();

        }
    }

    public void deleteEmployee(String id) {
        try {
            employeeList.removeIf(emp -> emp.getId().equals(id));
        } catch (CommonException e) {
            throw new CommonException();
        }
    }
}
