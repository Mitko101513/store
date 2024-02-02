package com.rental.store.web;

import com.rental.store.dto.ReturnRequest;
import com.rental.store.dto.ReturnResponse;
import com.rental.store.service.ReturnService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/return")
public class ReturnController {

    private final ReturnService returnService;

    public ReturnController(ReturnService returnService) {
        this.returnService = returnService;
    }

    @PostMapping()
    public ResponseEntity<ReturnResponse> returned(@RequestBody List<ReturnRequest> returnRequests) {
        return ResponseEntity.ok(returnService.returned(returnRequests));
    }
}
