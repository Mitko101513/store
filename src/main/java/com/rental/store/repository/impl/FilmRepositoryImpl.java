package com.rental.store.repository.impl;

import com.rental.store.domain.Film;
import com.rental.store.domain.NewReleaseFilm;
import com.rental.store.domain.OldFilm;
import com.rental.store.domain.RegularFilm;
import com.rental.store.repository.FilmRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Repository
public class FilmRepositoryImpl implements FilmRepository {

    List<Film> films;

    @PostConstruct
    void init() {
        if (Objects.isNull(films)) {
            films = new ArrayList<>();
            films.add(new Film("Matrix 11", new NewReleaseFilm()));
            films.add(new Film("Spider Man", new RegularFilm()));
            films.add(new Film("Spider Man 2", new RegularFilm()));
            films.add(new Film("Out of Africa", new OldFilm()));
        }
    }

    @Override
    public Film findByTitle(String title) {
        return films.stream().filter(film -> film.getTitle().equals(title))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Film does not exists!"));
    }

    @PreDestroy
    void destroy() {
        films.clear();
    }
}
