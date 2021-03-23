package com.spring02.udemy.demo.dao

import com.spring02.udemy.demo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee,Int> {
}