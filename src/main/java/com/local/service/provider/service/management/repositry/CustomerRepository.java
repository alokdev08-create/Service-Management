package com.local.service.provider.service.management.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.service.provider.service.management.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findById(Integer id);

	Customer findByName(String name);

	Customer findByEmail(String email);

	List<Customer> findByAddress(String address);

}
