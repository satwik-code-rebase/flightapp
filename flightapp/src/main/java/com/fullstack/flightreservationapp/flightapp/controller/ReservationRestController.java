package com.fullstack.flightreservationapp.flightapp.controller;

import com.fullstack.flightreservationapp.flightapp.dto.CreateReservationRequest;
import com.fullstack.flightreservationapp.flightapp.dto.UpdateReservationRequest;
import com.fullstack.flightreservationapp.flightapp.modal.Flight;
import com.fullstack.flightreservationapp.flightapp.modal.Passenger;
import com.fullstack.flightreservationapp.flightapp.modal.Reservation;
import com.fullstack.flightreservationapp.flightapp.repositories.FlightRepo;
import com.fullstack.flightreservationapp.flightapp.repositories.PassengerRepo;
import com.fullstack.flightreservationapp.flightapp.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/flightServices")
public class ReservationRestController {
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private ReservationRepo reservationRepo;

    //api to get the list of all flights-----------------------------------------------------------
    @GetMapping("/getAllFlights")
    public ResponseEntity<List<Flight>> findFlights() {
        return new ResponseEntity<>(flightRepo.findAll(), HttpStatus.OK);
    }
    //api to create new reservation----------------------------------------------------------------
    @PostMapping("/saveReservation")
    @Transactional
    public ResponseEntity<Reservation> saveReservation(CreateReservationRequest request) {
        //get flight-------------------------------
        Flight flight = flightRepo.findById(request.getFlightId()).get();
        //create new passenger---------------------
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setMiddleName(request.getPassengerMiddleName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepo.save(passenger);
        //save reservation------------------------
        Reservation reservation=new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        reservation.setNumberOfBags(0);
        Reservation savedReservation=reservationRepo.save(reservation);
        return new ResponseEntity<>(savedReservation,HttpStatus.OK);
    }
    //api to get reservation by id--------------------------------------------------
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> findReservation(@PathVariable  int id){
        return new ResponseEntity<>(reservationRepo.findById(id).get(),HttpStatus.OK);
    }

    //api to update reservation----------------------------------------------------
    @PutMapping("/updateReservation")
    public ResponseEntity<Reservation> updateReservation(UpdateReservationRequest request){
        Reservation reservation=reservationRepo.findById(request.getId()).get();
        reservation.setCheckedIn(request.isCheckIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        return new ResponseEntity<>(reservationRepo.save(reservation),HttpStatus.OK);
    }

}
