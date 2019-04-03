package com.thansoft.springbootjpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thansoft.springbootjpa.entity.Person;
import com.thansoft.springbootjpa.repository.PersonRepository;
import com.thansoft.springbootjpa.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return (List<Person>) personRepository.findAll();
	}

	@Override
	public Person create(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}

	@Override
	public List<Person> getPersonsBySalary(double salary) {
		// TODO Auto-generated method stub
		return personRepository.salaryGreaterThanEqualNativeQuery(salary);
	}

	@Override
	public List<Person> getPersonsByAge(int age) {
		return personRepository.ageLessThanEqualQuery(age);
	}

	@Override
	public long personCountNamedNative() {
		// TODO Auto-generated method stub
		return personRepository.personCountNamedNative();
	}

	@Override
	public Page<Person> getPersons(PageRequest request) {
		// TODO Auto-generated method stub
		return personRepository.findAll(request);
	}

	@Override
	public Page<Person> getPersons(Pageable request) {
		// TODO Auto-generated method stub
		return personRepository.findAll(request);
	}

}
