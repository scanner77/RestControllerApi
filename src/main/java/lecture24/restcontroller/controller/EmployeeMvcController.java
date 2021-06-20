package lecture24.restcontroller.controller;

import lecture24.restcontroller.eintity.Employee;
import lecture24.restcontroller.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web")

public class EmployeeMvcController {
    @Autowired
    private EmployeeService employeeService;

    //Homepage html page
    @GetMapping("/")
    public String welcomePage(Model model){
    //As soon as this page loads, we need to show data also
        List<Employee> allEmps = employeeService.getAllEmployees();
        //We want to display the data in allEmps in index, how can you do that?
        model.addAttribute("allEmps",allEmps);
        return "index";
        }
//        public void testing(){
//        Employee emp = new Employee();
//            emp.setId(45);
//            emp.setName("Haris");
//            emp.setSalary(123445);
//        }

       //Add Employee html page
    @GetMapping("/newEmp")
    public String newEmployeePage(Model model){
        Employee emp = new Employee();
        model.addAttribute("emp",emp);
        //Whenever this method is called then the new HTML page can access the blank employee object
        return "newEmployee";
    }
    //POST INTO THE DATABASE
    //Here, In post method, we need to tell server that the request is coming from the body of "POST request"
    @PostMapping("/addEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/web/";
        //Here controller save method will call the save employee method of service layer
    }

    //update
    //this is a request to go to edit in editEmp html page
    @GetMapping("/editEmp/{id}")
    public String editEmployeePage(@PathVariable int id, Model model){
        Employee emp = employeeService.getOneEmployee(id).orElse(new Employee());//Java 8 syntax
        model.addAttribute("emp",emp);
        model.addAttribute("id",id);
        //Whenever this method is called then the new HTML page can access the blank employee object
        return "editEmp";
    }

    //*****IMPORTANT***** Update employee below will update the data coming from the above editEmployeePage
    // Here this method takes id because request is coming from get method
    //For updating it is sending the data, so it should be post


    //Delete an employee from database
    //In index.html, we are using a href for this /deleteEmp. Href can be accessed by get request only
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        //Here controller save method will call the save employee method of service layer
        return "redirect:/web/";
    }



    //Edit and update an employee
    //We need to use post mapping to edit an emp in @Controller and send back to database
    @PostMapping("/editEmp")
    public String editEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        //Here controller save method will call the save employee method of service layer
        return "redirect:/web/";
    }

    //*****Important****** the data sent by above update method is recieved by this updateEmployee method
    // and stores it in database and returns to homepage.


    //GET ONE EMPLOYEE USING ITS ID
//    @GetMapping("/getOneEmployee/{id}")
//    public Optional<Employee> getOneEmployee(@PathVariable int id){
//        return employeeService.getOneEmployee(id);
//    }

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





}
