package com.rental.store.service;

import com.rental.store.domain.Film;
import com.rental.store.domain.RegularFilm;
import com.rental.store.dto.ReturnRequest;
import com.rental.store.dto.ReturnResponse;
import com.rental.store.repository.FilmRepository;
import com.rental.store.service.impl.ReturnServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReturnServiceTest {

    @Mock
    FilmRepository filmRepository;

    @InjectMocks
    ReturnServiceImpl returnService;

    static List<ReturnRequest> returnRequests;

    @BeforeAll
    static void init() {
        returnRequests = new ArrayList<>();
        returnRequests.add(new ReturnRequest("Spider Man 2", 3));
    }

    @BeforeEach
    void setMockOutput() {
        when(filmRepository.findByTitle("Spider Man 2")).thenReturn(new Film("Spider Man 2", new RegularFilm()));
    }

    @Test
    void returnTotalPrice() {
        ReturnResponse response = returnService.returned(returnRequests);
        assertEquals(90.0, response.totalLatePrice());
    }
}
