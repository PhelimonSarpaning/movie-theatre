package com.jpmc.theater;

import com.jpmc.theater.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWith50PercentDiscount() {
        Ticket ticket = new Ticket(new Discount());
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, ticket.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }
}
