package com.oms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {

}
