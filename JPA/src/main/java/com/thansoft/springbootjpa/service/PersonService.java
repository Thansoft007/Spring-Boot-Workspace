package com.thansoft.springbootjpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.thansoft.springbootjpa.entity.Person;


public interface PersonService {

	List<Person> getPersons();

	Person create(Person person);

	List<Person> getPersonsBySalary(double salary);

	List<Person> getPersonsByAge(int age);

	long personCountNamedNative();

	Page<Person> getPersons(PageRequest request);
	
	Page<Person> getPersons(Pageable request);

}
