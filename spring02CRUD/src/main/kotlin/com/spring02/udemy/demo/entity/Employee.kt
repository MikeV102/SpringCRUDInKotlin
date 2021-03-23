package com.spring02.udemy.demo.entity

import javax.persistence.*


@Entity
@Table(name = "employee")
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id = 0

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "email")
    var email: String? = null

    constructor() {}
    constructor(firstName: String?, lastName: String?, email: String?) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }


    override fun toString(): String {
        return "Employee [id=$id, firstName=$firstName, lastName=$lastName, email=$email]"
    }
}