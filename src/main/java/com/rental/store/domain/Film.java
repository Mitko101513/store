package com.rental.store.domain;

public class Film {
    private String title;
    private FilmType type;

    public Film(String title, FilmType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FilmType getType() {
        return type;
    }

    public void setType(FilmType type) {
        this.type = type;
    }
}
