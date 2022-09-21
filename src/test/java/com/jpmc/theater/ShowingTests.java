package com.jpmc.theater;

import com.jpmc.theater.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowingTests {
    @Test
    void testShowingShowsActualShow() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        Showing showing = new Showing(spiderMan, 5, time);

        assertEquals(time, showing.getStartTime());
        assertEquals(1, showing.getMovie().getSpecialCode());
        assertEquals(Duration.parse("PT1H30M"), showing.getMovie().getRunningTime());
        assertEquals(12.5, showing.getMovie().getTicketPrice());
        assertEquals("Spider-Man: No Way Home", showing.getMovie().getTitle());
        assertEquals(time, showing.getStartTime());
    }
}
