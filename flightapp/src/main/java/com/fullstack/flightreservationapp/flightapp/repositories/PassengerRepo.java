package com.fullstack.flightreservationapp.flightapp.repositories;

import com.fullstack.flightreservationapp.flightapp.modal.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}
