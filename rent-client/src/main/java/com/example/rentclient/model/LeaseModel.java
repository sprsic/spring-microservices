package com.example.rentclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaseModel {
    private UserModel user;
    private List<MovieModel> movie;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<MovieModel> getMovie() {
        return movie;
    }

    public void setMovie(List<MovieModel> movie) {
        this.movie = movie;
    }
}
