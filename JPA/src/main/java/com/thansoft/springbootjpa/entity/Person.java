package com.thansoft.springbootjpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
@Table(name = "person")
@NamedQueries({
		@NamedQuery(name = "Person.findByAgeLessThanEqualNamedQuery", query = "select p from Person p where p.age <=?1"),
		@NamedQuery(name = "Person.salaryGreaterThanEqualNativeQuery", query = "select p from Person p where p.salary>=:salary") })

@NamedNativeQueries({
		@NamedNativeQuery(name = "Person.personCountNamedNative", query = "select count(*) as countNative from Person") })

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_id_person")
	@GenericGenerator(name = "custom_id_person", strategy = "com.thansoft.springbootjpa.generator.CustomIdentifierGenerator")
	private String id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private int age;
	private double salary;
	@Column(name = "created_date")
	private Date createdDate;

	protected Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String id, String firstName, String lastName, int age, double salary, Date createdDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", salary="
				+ salary + ", createdDate=" + createdDate + "]";
	}
}
