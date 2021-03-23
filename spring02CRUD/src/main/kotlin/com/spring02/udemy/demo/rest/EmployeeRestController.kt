package com.spring02.udemy.demo.rest


import com.spring02.udemy.demo.entity.Employee
import com.spring02.udemy.demo.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class EmployeeRestController @Autowired constructor(theEmployeeService: EmployeeService) {
    private val employeeService: EmployeeService = theEmployeeService

    @GetMapping("/employees")
    fun findAll(): List<Employee?>? {
        return employeeService.findAll()
    }

    @GetMapping("/employees/{employeeId}")
    fun getEmployee(@PathVariable employeeId: Int): Employee {
        return employeeService.findById(employeeId)
            ?: throw RuntimeException("Employee id not found - $employeeId")
    }

    @PostMapping("/employees")
    fun addEmployee(@RequestBody theEmployee: Employee): Employee {
        theEmployee.id = 0
        employeeService.save(theEmployee)
        return theEmployee
    }

    @PutMapping("/employees")
    fun updateEmployee(@RequestBody theEmployee: Employee): Employee {
        employeeService.save(theEmployee)
        return theEmployee
    }

    @DeleteMapping("/employees/{employeeId}")
    fun deleteEmployee(@PathVariable employeeId: Int): String {
        val tempEmployee: Employee = employeeService.findById(employeeId)
            ?: throw RuntimeException("Employee id not found - $employeeId")

        employeeService.deleteById(employeeId)
        return "Deleted employee id - $employeeId"
    }

}
