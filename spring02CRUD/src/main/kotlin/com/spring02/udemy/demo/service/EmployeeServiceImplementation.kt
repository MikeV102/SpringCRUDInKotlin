package com.spring02.udemy.demo.service

import com.spring02.udemy.demo.dao.EmployeeDAO
import com.spring02.udemy.demo.dao.EmployeeRepository
import com.spring02.udemy.demo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class EmployeeServiceImplementation
@Autowired
constructor(private val employeeRepository: EmployeeRepository) : EmployeeService {



    override fun findAll(): List<Employee?>? {
        return employeeRepository.findAll()
    }

    override fun findById(theId: Int): Employee? {
        return employeeRepository.findById(theId).get()
    }


    override fun save(theEmployee: Employee?) {
        employeeRepository.save(theEmployee!!)
    }


    override fun deleteById(theId: Int) {
        employeeRepository.deleteById(theId)
    }

}