package com.rental.store.service;

import com.rental.store.dto.RentRequest;
import com.rental.store.dto.RentResponse;

import java.util.List;

public interface RentService {

    RentResponse rent(List<RentRequest> rentList);
}
