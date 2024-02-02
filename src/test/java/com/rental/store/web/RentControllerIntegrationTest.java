package com.rental.store.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rental.store.dto.RentRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RentControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void rentPost() throws Exception {
        List<RentRequest> rentRequestList;
        rentRequestList = new ArrayList<>();
        rentRequestList.add(new RentRequest("Spider Man", 3));
        rentRequestList.add(new RentRequest("Out of Africa", 4));
        mvc.perform(post("/api/v1/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rentRequestList)))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rentalList").isNotEmpty())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void rentPostFilmNotExist() throws Exception {
        List<RentRequest> rentRequestList;
        rentRequestList = new ArrayList<>();
        rentRequestList.add(new RentRequest("Undefined", 3));
        mvc.perform(post("/api/v1/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rentRequestList)))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NoSuchElementException))
                .andExpect(jsonPath("$.errorMessage").value( "Film does not exists!"));
    }
}