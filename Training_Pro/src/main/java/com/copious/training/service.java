package com.copious.training;

import com.training.exceptions.commonException;
import com.training.exceptions.employeeNotFoundException;
import com.training.exceptions.nothingToAddException;
import com.training.exceptions.processRuntimeErrorException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class service {

    private final List<employee> employeeList = new ArrayList<>(Arrays.asList(

            new employee("12", "Jhon", "Manager"),
            new employee("15", "copious", "employee"),
            new employee("17", "discovery", "client"),
            new employee("20", "Akhand", "Mentor"),
            new employee("22", "Aman", "employee"),
            new employee("25", "Draco", "client")

    ));

//        employeeList.forEach( list -> { System.out.println(employeeList); });


    public List<employee> getAllEmployeeList() {
        return employeeList;
    }

    public employee getEmployee(String id) {
        return employeeList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public List<employee> sortEmployee() throws IndexOutOfBoundsException, processRuntimeErrorException {
        try {
            employeeList.sort((o1, o2) -> o1.compareTo(o2));

        } catch ( IndexOutOfBoundsException |  processRuntimeErrorException e ) {
            e.printStackTrace();
            throw new processRuntimeErrorException();
        }
        return employeeList;
    }


    public List<employee> addEmployee(employee employe) throws nothingToAddException {
        try {
            employeeList.add(employe);

        } catch (nothingToAddException e) {
            throw new nothingToAddException();
        }
        return employeeList;
    }


    public void updateEmployee(employee employe, String id) throws employeeNotFoundException, processRuntimeErrorException {
        int counter = 0;
        try {
            for (employee employee1 : employeeList) {
                if (employee1.getId().equals(id)) {
                    employeeList.set(counter, employe);
                }
                counter++;
            }
        } catch (employeeNotFoundException  | processRuntimeErrorException error) {
            throw new employeeNotFoundException();

        }
    }

    public void deleteEmployee(String id) {
        try {
            employeeList.removeIf(emp -> emp.getId().equals(id));
        } catch (commonException e) {
            throw new commonException();
        }
    }
}
