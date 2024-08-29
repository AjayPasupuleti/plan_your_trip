package com.oms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.Trips;

@Repository
public interface TripRepository extends JpaRepository<Trips,Long>{

}
