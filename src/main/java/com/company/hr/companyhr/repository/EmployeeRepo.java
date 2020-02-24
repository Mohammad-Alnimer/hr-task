package com.company.hr.companyhr.repository;

import com.company.hr.companyhr.enitiry.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findEmployeeEntitiesByDeptNameOrFirstName(String dept, String firstName);
}
