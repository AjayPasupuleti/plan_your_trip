package com.oms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.Reviews;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long> {
	
}
