package com.spring02.udemy.demo.dao

import com.spring02.udemy.demo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class EmployeeDAOJpaImplementation
@Autowired
constructor(private val entityManager: EntityManager) : EmployeeDAO {

    override fun findAll(): List<Employee?>? {
        val query = entityManager.createQuery("from Employee ")
        return query.resultList as MutableList<Employee>
    }

    override fun findById(theId: Int): Employee? {
        return entityManager.find(Employee::class.java, theId)
    }

    override fun save(theEmployee: Employee?) {
        val employee = entityManager.merge(theEmployee)
        theEmployee!!.id = employee!!.id
    }

    override fun deleteById(theId: Int) {

        val query = entityManager.createQuery("delete from Employee where id =:employeeId")

        query.setParameter("employeeId",theId)

        query.executeUpdate()
    }
}