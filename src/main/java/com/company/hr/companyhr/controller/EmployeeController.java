package com.company.hr.companyhr.controller;

import com.company.hr.companyhr.dao.EmployeeDao;
import com.company.hr.companyhr.enitiry.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Iterable<EmployeeEntity> getEmployeeByNameOrDept(@RequestParam String deptName,
                                                            @RequestParam String empName) {
        return this.employeeDao.getEmployeeByNameOrDept(deptName, empName);
    }

    @PostMapping("/addEmployee")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity emp) {
        return this.employeeDao.addEmp(emp);
    }

    @PutMapping("/editEmployee/{id}")
    public EmployeeEntity editEmployee(@RequestBody EmployeeEntity emp, @PathVariable Long id) {
        emp.setEmployeeId(id);
        return this.employeeDao.editEmp(emp);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
         if (this.employeeDao.delete(id))
            return "Success Deleted";
         else
             return "User Not Exist";

    }

}
