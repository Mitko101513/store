package com.rental.store.service;

import com.rental.store.dto.ReturnRequest;
import com.rental.store.dto.ReturnResponse;

import java.util.List;

public interface ReturnService {

    ReturnResponse returned(List<ReturnRequest> returnRequestList);
}
