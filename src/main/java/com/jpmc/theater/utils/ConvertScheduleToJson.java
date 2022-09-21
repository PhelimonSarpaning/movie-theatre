package com.jpmc.theater.utils;

import com.jpmc.theater.Showing;
import com.jpmc.theater.model.Schedule;

public class ConvertScheduleToJson {
    Showing showing;

    public ConvertScheduleToJson(Showing showing) {
        this.showing = showing;
    }

    public Schedule setScheduleJson() {
        Schedule schedule = new Schedule();
        schedule.setSequenceOfDay(showing.getSequenceOfTheDay());
        schedule.setMovieFee(showing.getMovieFee());
        schedule.setMovieTile(showing.getMovie().getTitle());
        schedule.setStartTime(showing.getStartTime());
        schedule.setMovieRunningTime(Formatter.humanReadableFormat(showing.getMovie().getRunningTime()));

        return schedule;
    }

}
