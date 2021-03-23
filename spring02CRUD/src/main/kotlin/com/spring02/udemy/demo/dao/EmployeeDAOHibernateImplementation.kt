package com.spring02.udemy.demo.dao

import com.spring02.udemy.demo.entity.Employee
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager


@Repository
class EmployeeDAOHibernateImpl
@Autowired
constructor( private val entityManager: EntityManager) : EmployeeDAO {

    override fun findAll(): List<Employee> {

        val currentSession =
            entityManager.unwrap(Session::class.java)

        val theQuery: Query<Employee> =
            currentSession.createQuery("from Employee", Employee::class.java)


        return theQuery. resultList
    }

    override fun findById(theId: Int): Employee {

        val currentSession =
            entityManager.unwrap(Session::class.java)


        return currentSession[Employee::class.java, theId]
    }

    override fun save(theEmployee: Employee?) {

        val currentSession = entityManager.unwrap(Session::class.java)

        currentSession.saveOrUpdate(theEmployee)
    }

    override fun deleteById(theId: Int) {

        val currentSession = entityManager.unwrap(Session::class.java)

        val theQuery = currentSession.createQuery(
            "delete from Employee where id=:employeeId"
        )
        theQuery.setParameter("employeeId", theId)
        theQuery.executeUpdate()
    }
}

