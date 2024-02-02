package com.rental.store.domain;

public class NewReleaseFilm extends FilmType {

    private static final double PREMIUM_PRICE = 40.0;

    @Override
    public double calculateRentPrice(int days) {
        return PREMIUM_PRICE * days;
    }

    @Override
    public double calculateLatePrice(int extraDays) {
        return PREMIUM_PRICE * extraDays;
    }
}
