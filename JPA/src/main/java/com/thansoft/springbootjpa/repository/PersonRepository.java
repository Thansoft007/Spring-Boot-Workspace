package com.thansoft.springbootjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thansoft.springbootjpa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

	List<Person> salaryGreaterThanEqualNativeQuery(double salary);

	@Query("select p from Person p where p.age=26")
	List<Person> ageLessThanEqualQuery(int age);

	long personCountNamedNative();

}
