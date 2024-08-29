package com.oms.project.repository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

}
