package com.oms.project.repository;

import org.springframework.stereotype.Repository;

import com.oms.project.model.Partners;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OmsRepository extends JpaRepository<Partners,Long> {

}
