package com.rental.store.dto;

public class Returned {

    private String filmTitle;
    private int extraDays;
    private double calculatedLatePrice;

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public int getExtraDays() {
        return extraDays;
    }

    public void setExtraDays(int extraDays) {
        this.extraDays = extraDays;
    }

    public double getCalculatedLatePrice() {
        return calculatedLatePrice;
    }

    public void setCalculatedLatePrice(double calculatedLatePrice) {
        this.calculatedLatePrice = calculatedLatePrice;
    }
}
