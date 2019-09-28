package com.flight.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Flight;
import com.flight.model.FlightBookingDetails;

@Repository
public interface FlightBookingRepository  extends JpaRepository<FlightBookingDetails, Long> {
}
