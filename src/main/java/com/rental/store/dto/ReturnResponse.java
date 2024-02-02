package com.rental.store.dto;

import java.util.List;

public record ReturnResponse(List<Returned> returnedList, double totalLatePrice) {
}
