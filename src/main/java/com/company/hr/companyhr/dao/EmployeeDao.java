package com.company.hr.companyhr.dao;

import com.company.hr.companyhr.enitiry.EmployeeEntity;
import com.company.hr.companyhr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {


    @Autowired
    private EmployeeRepo employeeRepo;

    public Iterable<EmployeeEntity> getEmployeeByNameOrDept(String deptName, String empName) {
        return this.employeeRepo.findEmployeeEntitiesByDeptNameOrFirstName(deptName, empName);
    }

    public EmployeeEntity addEmp(EmployeeEntity emp) {
        return this.employeeRepo.save(emp);
    }

    public EmployeeEntity editEmp(EmployeeEntity emp) {
        return this.employeeRepo.save(emp);
    }

    public boolean delete(Long id) {
        if (this.employeeRepo.existsById(id)) {
            this.employeeRepo.deleteById(id);
            return true;
        } else
            return false;
    }

}
