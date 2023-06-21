package com.fullstack.flightreservationapp.flightapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationRequest {
    private int id;
    private boolean checkIn;
    private int numberOfBags;
}
