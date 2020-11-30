package com.copious.training;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class controller {

    @Autowired
    private service empService;


    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate emp_birthdate;


    @RequestMapping("/employees")
    public List<employee> all_employees() {

        return empService.getAllEmployeeList();
    }

    @RequestMapping("/employees/{id}")
    public employee getEmployee(@PathVariable("id") String id) {
        return empService.getEmployee(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public List<employee> addEmployee(@RequestBody employee employe) {
        return empService.addEmployee(employe);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody employee employe, @PathVariable("id") String id) {
        empService.updateEmployee(employe, id);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
        empService.deleteEmployee(id);
    }

}
