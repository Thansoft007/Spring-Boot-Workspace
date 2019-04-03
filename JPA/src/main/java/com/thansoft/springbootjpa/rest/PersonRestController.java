package com.thansoft.springbootjpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thansoft.springbootjpa.entity.Person;
import com.thansoft.springbootjpa.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("person")
@RestController("api")
public class PersonRestController {

	@Autowired
	PersonService personService;

	@ApiOperation(value = "for getting list of persons")
	@GetMapping("person")
	List<Person> person() {
		return personService.getPersons();
	}

	@ApiOperation(value = "save person")
	@PostMapping("person")
	Person person(@RequestBody Person person) {
		return personService.create(person);
	}

	@ApiOperation(value = "for getting list of persons by Salary greater than or equals")
	@GetMapping("personBySalary")
	List<Person> personsBySalary(@RequestParam(required = true) double salary) {
		return personService.getPersonsBySalary(salary);
	}

	@ApiOperation(value = "for getting list of persons by Age less than or equals")
	@GetMapping("personByAge")
	List<Person> personsByAge(@RequestParam(required = true) int age) {
		return personService.getPersonsByAge(age);
	}

	@ApiOperation(value = "for getting list of persons by page")
	@GetMapping("persons/pages")
	Page<Person> getPersons(@RequestParam(required = true) int page, @RequestParam(required = true) int size) {
		return personService.getPersons(PageRequest.of(page, size,Sort.by("firstName").descending()));
	}
	
	@ApiOperation(value = "for getting list of persons by page slice")
	@GetMapping("persons/pagesSlice")
	Slice<Person> getPersonsSlice(@RequestParam(required = true) int page, @RequestParam(required = true) int size) {
		return personService.getPersons(PageRequest.of(page, size,Sort.by("firstName").descending()));
	}
	

	@ApiOperation(value = "for getting countt of persons")
	@GetMapping("personsCount")
	long personsCount() {
		return personService.personCountNamedNative();
	}

}
