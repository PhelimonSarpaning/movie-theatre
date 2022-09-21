package com.jpmc.theater.model;

import java.time.LocalDateTime;

public class Schedule {
    private int sequenceOfDay;
    private LocalDateTime startTime;
    private String movieTile;
    private String movieRunningTime;
    private double movieFee;

    public int getSequenceOfDay() {
        return sequenceOfDay;
    }

    public void setSequenceOfDay(int sequenceOfDay) {
        this.sequenceOfDay = sequenceOfDay;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getMovieTile() {
        return movieTile;
    }

    public void setMovieTile(String movieTile) {
        this.movieTile = movieTile;
    }

    public String getMovieRunningTime() {
        return movieRunningTime;
    }

    public void setMovieRunningTime(String movieRunningTime) {
        this.movieRunningTime = movieRunningTime;
    }

    public double getMovieFee() {
        return movieFee;
    }

    public void setMovieFee(double movieFee) {
        this.movieFee = movieFee;
    }
}
