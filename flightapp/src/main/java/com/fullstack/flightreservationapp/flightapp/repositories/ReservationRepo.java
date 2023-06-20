package com.fullstack.flightreservationapp.flightapp.repositories;

import com.fullstack.flightreservationapp.flightapp.modal.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
}
