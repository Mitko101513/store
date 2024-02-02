package com.rental.store.domain;

public class RegularFilm extends FilmType {

    private static final double BASIC_PRICE = 30.0;

    @Override
    public double calculateRentPrice(int days) {
        double price = BASIC_PRICE;
        if (days > 3) {
            return price += BASIC_PRICE * (days - 3);
        }
        return price;
    }

    @Override
    public double calculateLatePrice(int extraDays) {
        return BASIC_PRICE * extraDays;
    }
}
