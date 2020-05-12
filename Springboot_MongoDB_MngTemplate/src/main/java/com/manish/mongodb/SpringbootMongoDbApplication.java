package com.manish.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMongoDbApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();
		customerRepository.save(new Customer("Alice", "Smith"));
		// fetch all customers
		customerRepository.save(new Customer("manish", "sharma"));
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("Alice"));
		System.out.println("Customers found with findByLastName('Smith'):");
		int n = customerRepository.updateByFirstName("Alice", 41);
		System.out.println("Number of records updated : " + n);
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}