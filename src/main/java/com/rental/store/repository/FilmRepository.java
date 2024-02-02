package com.rental.store.repository;

import com.rental.store.domain.Film;

public interface FilmRepository {

    Film findByTitle(String title);
}
