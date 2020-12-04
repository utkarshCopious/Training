package com.copious.training.controller;

import com.copious.training.promodel.Employee;
import com.copious.training.service.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Utkarsh Awasthi
 **/

@RestController
public class Controller {

    @Autowired
    private Service empService;


    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate empBirthDate;


    @RequestMapping("/employees")
    public List<Employee> allEmployees() {

        return empService.getAllEmployeeList();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") String id) {
        return empService.getEmployee(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public List<Employee> addEmployee(@RequestBody Employee employe) {
        return empService.addEmployee(employe);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody Employee employe, @PathVariable("id") String id) {
        empService.updateEmployee(employe, id);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
        empService.deleteEmployee(id);
    }

}
