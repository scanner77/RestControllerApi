package lecture24.restcontroller.controller;

import lecture24.restcontroller.eintity.Employee;
import lecture24.restcontroller.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

        //Homepage
    @GetMapping("/")
    public String testing(){

        return "working fine...";
        }

    //GET ONE EMPLOYEE USING ITS ID
    @GetMapping("/getOneEmployee/{id}")
    public Optional<Employee> getOneEmployee(@PathVariable int id){
        return employeeService.getOneEmployee(id);
    }

    //GET ONE EMPLOYEE USING ITS Name
    @GetMapping("/getEmployeeByName/{name}")
    public Optional<Employee> getOneEmployee(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }

    //GET ALL EMPLOYEES
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
}

    //POST INTO THE DATABASE
    //Here, In post method, we need to tell server that the request is coming from the body of "POST request"
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
       //Here controller save method will call the save employee method of service layer

    }

    //Update an employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(Employee employee){
        return employeeService.saveEmployee(employee);
        //Here controller save method will call the save employee method of service layer

    }

    //Delete an employee
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id){
         employeeService.deleteEmployee(id);
        //Here controller save method will call the save employee method of service layer

    }

}
