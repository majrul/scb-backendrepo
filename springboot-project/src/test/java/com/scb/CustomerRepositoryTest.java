package com.scb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scb.entity.Address;
import com.scb.entity.Customer;
import com.scb.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void addCustomer() {
		Customer customer = new Customer();
		customer.setName("Abhishek");
		customer.setEmail("abhishek@gmail.com");
		customer.setPassword("12345678");
		
		Address address = new Address();
		address.setPincode(400003);
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		
		customer.setAddress(address);
		
		customerRepository.save(customer);
		
		assertThat(customer.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void fetchAll() {
		long rows = customerRepository.count();
		List<Customer> list = customerRepository.findAll();
		assertThat(list.size()).isEqualTo(rows);
	}
	
	@Test
	public void fetchByEmail() {
		Optional<Customer> customer = customerRepository.findByEmail("majrul@gmail.com");
		assertThat(customer.isPresent()).isEqualTo(true);
	}

	@Test
	public void fetchByCity() {
		List<Customer> list = customerRepository.findByCity("Mumbai");
		assertThat(list.size()).isGreaterThan(0);
	}
}
