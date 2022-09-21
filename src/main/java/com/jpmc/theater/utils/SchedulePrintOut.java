package com.jpmc.theater.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jpmc.theater.Showing;
import com.jpmc.theater.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class SchedulePrintOut {
    public static List<Schedule> schedules = new ArrayList<>();
    LocalDateProvider provider = LocalDateProvider.singleton();

    public static void callConverter(Showing s) {
        ConvertScheduleToJson convertScheduleToJson = new ConvertScheduleToJson(s);
        Schedule movieSchedule = convertScheduleToJson.setScheduleJson();
        schedules.add(movieSchedule);
    }

    public void printSchedule(List<Showing> schedule) {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");
        schedule.forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " " + Formatter.humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee())
        );
        System.out.println("===================================================");
    }

    public void printScheduleJSON(List<Showing> schedule) {
        System.out.println("Schedule JSON");
        System.out.println("===================================================");
        for (Showing showing : schedule) {
            callConverter(showing);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            System.out.println(objectMapper.writeValueAsString(schedules));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===================================================");
    }
}
