package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import net.bytebuddy.implementation.MethodCall.ArgumentLoader.ForMethodParameterArrayElement.OfInvokedMethod;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository, OrdersRepository ordersRepository) {
		return arg -> {
			// optionally use in addition to or in place of data.sql seeding
			Customer john = new Customer("John", "Alexander", "07/28/2023");
			customerRepository.save(john);

			Customer jenny = new Customer("Jenny", "Smith", "07/28/2023");
			customerRepository.save(jenny);

			// Q: see if you can figure out how to create Order records, next....
			// order table
			// unique id (VARCHAR)
			// foreign key to the customer record
			// shipped_location column for where the order gets sent to (VARCHAR)
			// purchase_total for how much the customer spent (VARCHAR)
			// establish the "relationship" between customer table and orders table e.g. @OneToMany @ManyToOne
			Orders orders1 = new Orders ("Ohio","200");
			ordersRepository.save(orders1);
		};
	}
}
