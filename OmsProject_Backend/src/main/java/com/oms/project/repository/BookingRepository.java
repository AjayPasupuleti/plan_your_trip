package com.oms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.project.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

}
