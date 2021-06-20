package lecture24.restcontroller.service;

import lecture24.restcontroller.eintity.Employee;
import lecture24.restcontroller.employeeRepository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    EmployeeService() {
    }

    //Update an employee into a database
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
        //Here controller save method will call the save employee method of service layer
    }

    public Employee editEmployee(Employee employee){
        return employeeRepo.save(employee);
        //Here controller save method will call the save employee method of service layer

    }

    //Delete an employee
    public void deleteEmployee( int id){
        employeeRepo.deleteById(id);
        //Here controller save method will call the save employee method of service layer
    }

    //Get one employee by ID
    public Optional<Employee> getOneEmployee(int id){
        return employeeRepo.findById(id);
    }

    //GET ONE EMPLOYEE USING ITS Name
    public Optional<Employee> getEmployeeByName(String name){
        return employeeRepo.findByName(name);
    }

    //GET ALL EMPLOYEES
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    //POST INTO THE DATABASE
    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);

    }














}
