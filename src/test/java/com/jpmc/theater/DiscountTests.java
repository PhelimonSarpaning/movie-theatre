package com.jpmc.theater;

import com.jpmc.theater.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTests {
    Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
    Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));

    @Test
    void getDiscount() {
        assertEquals(2.5, new Discount().getDiscount(showing));
    }

    @Test
    void getSpecialDiscount() {
        assertEquals(2.5, new Discount().getSpecialDiscount(spiderMan.getSpecialCode(), spiderMan.getTicketPrice()));
    }

    @Test
    void getSequenceDiscount() {
        assertEquals(0.0, new Discount().getSequenceDiscount(showing.getSequenceOfTheDay()));
        assertEquals(3.0, new Discount().getSequenceDiscount(1));
        assertEquals(2.0, new Discount().getSequenceDiscount(2));
    }

    @Test
    void getDate7thDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.parse("2022-09-07"), LocalTime.now()));
        assertEquals(1.0, new Discount().getDateDiscount(LocalDateTime.of(LocalDate.parse("2022-09-07"), LocalTime.now()), spiderMan.getTicketPrice()));
    }

    @Test
    void getTimeDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.parse("2022-09-10"), LocalTime.parse("14:03:50.512109")));
        assertEquals(3.125, new Discount().getTimeDiscount(LocalTime.from(LocalDateTime.of(LocalDate.parse("2022-09-10"), LocalTime.parse("14:03:50.512109"))), spiderMan.getTicketPrice()));
    }
}
