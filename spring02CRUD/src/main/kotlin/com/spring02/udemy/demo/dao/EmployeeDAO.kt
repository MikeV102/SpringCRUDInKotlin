package com.spring02.udemy.demo.dao

import com.spring02.udemy.demo.entity.Employee


interface EmployeeDAO {
    fun findAll(): List<Employee?>?
    fun findById(theId: Int): Employee?
    fun save(theEmployee: Employee?)
    fun deleteById(theId: Int)
}
