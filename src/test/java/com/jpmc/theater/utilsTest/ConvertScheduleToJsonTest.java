package com.jpmc.theater.utilsTest;

import com.jpmc.theater.Showing;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Schedule;
import com.jpmc.theater.utils.ConvertScheduleToJson;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertScheduleToJsonTest {
    Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
    LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    Showing showing = new Showing(spiderMan, 5, time);
    ConvertScheduleToJson convertScheduleToJsonTest = new ConvertScheduleToJson(showing);

    @Test
    void makeSureItConvertsToModel() {
        Schedule schedule = convertScheduleToJsonTest.setScheduleJson();

        assertEquals(time, schedule.getStartTime());
        assertEquals("(1 hour 30 minutes)", schedule.getMovieRunningTime());
        assertEquals("Spider-Man: No Way Home", schedule.getMovieTile());
        assertEquals(12.5, schedule.getMovieFee());
        assertEquals(5, schedule.getSequenceOfDay());
    }
}
