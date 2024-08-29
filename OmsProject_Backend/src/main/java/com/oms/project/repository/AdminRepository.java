package com.oms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.Admins;

@Repository
public interface AdminRepository extends JpaRepository<Admins,Long>{

}
