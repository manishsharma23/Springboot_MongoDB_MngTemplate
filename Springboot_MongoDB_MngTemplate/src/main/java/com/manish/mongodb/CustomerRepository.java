package com.manish.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	public Customer findByFirstName(@Param("name") String firstName);

	public List<Customer> findByLastName(String lastName);

	int updateByFirstName(String string, int age);
}
