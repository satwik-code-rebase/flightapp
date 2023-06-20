package com.fullstack.flightreservationapp.flightapp.repositories;

import com.fullstack.flightreservationapp.flightapp.modal.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{
}
