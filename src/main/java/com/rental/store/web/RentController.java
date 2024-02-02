package com.rental.store.web;

import com.rental.store.dto.RentRequest;
import com.rental.store.dto.RentResponse;
import com.rental.store.service.RentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping()
    public ResponseEntity<RentResponse> rent(@RequestBody List<RentRequest> rentRequests) {
        return ResponseEntity.ok(rentService.rent(rentRequests));
    }
}
