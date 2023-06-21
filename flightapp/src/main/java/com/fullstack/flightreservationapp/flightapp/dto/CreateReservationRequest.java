package com.fullstack.flightreservationapp.flightapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequest {
    private int flightId;
    private String passengerFirstName;
    private String passengerLastName;
    private String passengerMiddleName;
    private String passengerEmail;
    private String passengerPhone;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;
}
