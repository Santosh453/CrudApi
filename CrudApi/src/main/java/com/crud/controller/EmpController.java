package com.crud.controller;


import com.crud.entities.Employee;
import com.crud.repositries.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpRepo empRepo;

    @RequestMapping(value = "/getAllRecords")
    private List<Employee> getAllRecords(){

        return empRepo.findAll();
    }

//    @RequestMapping(value = "/getEmployee", method= RequestMethod.GET)
@GetMapping("/employees/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
    Employee employee = empRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
    return ResponseEntity.ok().body(employee);
}

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return empRepo.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                    @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = empRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setEmpName(employeeDetails.getEmpName());
        final Employee updatedEmployee = empRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(value = "/employees/{id}")
    private void deleteEmpById(@PathVariable(value = "id") Long id){
        empRepo.deleteById(id);
    }
}
