package com.jorgealvarez.myboda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgealvarez.myboda.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
