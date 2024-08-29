package com.oms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.AddOnCustomers;

@Repository
public interface AddOnCustomerRepository extends JpaRepository<AddOnCustomers,Long>{

}
