package com.rental.store.service.impl;

import com.rental.store.domain.Film;
import com.rental.store.dto.RentRequest;
import com.rental.store.dto.RentResponse;
import com.rental.store.dto.Rental;
import com.rental.store.repository.FilmRepository;
import com.rental.store.service.RentService;
import com.rental.store.service.ReturnService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    private final FilmRepository filmRepository;
    private final ReturnService returnService;

    public RentServiceImpl(FilmRepository filmRepository, ReturnService returnService) {
        this.filmRepository = filmRepository;
        this.returnService = returnService;
        System.out.println("Rent Service Initialized");
    }

    @Override
    public RentResponse rent(final List<RentRequest> rentList) {
        Rental rental;
        List<Rental> rentalList = new ArrayList<>();
        double pricePerFilm;
        double totalPrice = 0;
        for (RentRequest request : rentList) {
            Film film = filmRepository.findByTitle(request.title());
            rental = new Rental();
            rental.setFilmTitle(film.getTitle());
            rental.setRentDays(request.days());
            pricePerFilm = film.getType().calculateRentPrice(request.days());
            totalPrice = totalPrice + pricePerFilm;
            rental.setCalculatedPrice(pricePerFilm);
            rentalList.add(rental);
        }
        return new RentResponse(rentalList, totalPrice);
    }
}
