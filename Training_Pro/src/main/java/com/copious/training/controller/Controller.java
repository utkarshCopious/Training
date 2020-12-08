package com.copious.training.controller;

import com.copious.training.promodel.Employee;
import com.copious.training.service.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Utkarsh Awasthi
 **/

@Profile({Constants.PROFILE_LOCAL})
@RestController
@Api(value = "Employee based Crud Operations")
public class Controller {

    @Autowired
    private Service empService;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate empBirthDate;


    @RequestMapping("/employees")
    @ApiOperation(value = "gets a list of all employees", notes = "ArrayList <Employee>.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successfull"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    public List<Employee> allEmployees() {

        return empService.getAllEmployeeList();
    }

    @ApiOperation(value = "gets a specified employee")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") String id) {
        return empService.getEmployee(id);
    }


    @ApiOperation(value = "add an employee to the Db", notes = "Add to the ArrayList <Employee>.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public List<Employee> addEmployee(@RequestBody Employee employe) {
        return empService.addEmployee(employe);

    }


    @ApiOperation(value = "Update the employee list", notes = "Make modifications to the ArrayList <Employee>.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody Employee employe, @PathVariable("id") String id) {
        empService.updateEmployee(employe, id);
    }


    @ApiOperation(value = "remove employees from the db", notes = " Delete data from the ArrayList <Employee>.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
        empService.deleteEmployee(id);
    }

}
