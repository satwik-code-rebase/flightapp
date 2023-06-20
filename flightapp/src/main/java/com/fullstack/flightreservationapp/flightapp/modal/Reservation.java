package com.fullstack.flightreservationapp.flightapp.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Flight flight;
    @OneToOne
    private Passenger passenger;
}
