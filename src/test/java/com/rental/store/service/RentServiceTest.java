package com.rental.store.service;

import com.rental.store.domain.Film;
import com.rental.store.domain.RegularFilm;
import com.rental.store.dto.RentRequest;
import com.rental.store.dto.RentResponse;
import com.rental.store.repository.FilmRepository;
import com.rental.store.service.impl.RentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RentServiceTest {

    @Mock
    FilmRepository filmRepository;

    @InjectMocks
    RentServiceImpl rentService;

    static List<RentRequest> rentRequests;

    @BeforeAll
    static void init() {
        rentRequests = new ArrayList<>();
        rentRequests.add(new RentRequest("Spider Man 2", 3));
    }

    @BeforeEach
    void setMockOutput() {
        when(filmRepository.findByTitle("Spider Man 2")).thenReturn(new Film("Spider Man 2", new RegularFilm()));
    }

    @Test
    void rentTotalPrice() {
        RentResponse response = rentService.rent(rentRequests);
        assertEquals(30.0, response.totalPrice());
    }
}
