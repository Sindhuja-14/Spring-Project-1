package com.example.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String> {

	List<Customer> findAllByDate(String date);

}
