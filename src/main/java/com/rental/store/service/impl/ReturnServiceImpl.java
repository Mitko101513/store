package com.rental.store.service.impl;

import com.rental.store.domain.Film;
import com.rental.store.dto.*;
import com.rental.store.repository.FilmRepository;
import com.rental.store.service.ReturnService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {

    private final FilmRepository filmRepository;

    public ReturnServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public ReturnResponse returned(List<ReturnRequest> returnRequestList) {
        Returned returned;
        List<Returned> returnedList = new ArrayList<>();
        double latePricePerFilm;
        double totalLatePrice = 0;
        for (ReturnRequest request : returnRequestList) {
            Film film = filmRepository.findByTitle(request.title());
            returned = new Returned();
            returned.setFilmTitle(film.getTitle());
            returned.setExtraDays(request.extraDays());
            latePricePerFilm = film.getType().calculateLatePrice(request.extraDays());
            totalLatePrice = totalLatePrice + latePricePerFilm;
            returned.setCalculatedLatePrice(latePricePerFilm);
            returnedList.add(returned);
        }
        return new ReturnResponse(returnedList, totalLatePrice);
    }
}
