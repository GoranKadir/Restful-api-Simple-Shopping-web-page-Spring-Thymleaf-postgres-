package com.gorankadir.se.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gorankadir.se.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
