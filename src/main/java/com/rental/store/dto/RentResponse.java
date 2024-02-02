package com.rental.store.dto;

import java.util.List;

public record RentResponse(List<Rental> rentalList, double totalPrice) {
}
