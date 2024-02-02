package com.rental.store.domain;

public abstract class FilmType {

    public abstract double calculateRentPrice(int days);
    public abstract double calculateLatePrice(int extraDays);
}
