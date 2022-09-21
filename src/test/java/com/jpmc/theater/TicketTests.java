package com.jpmc.theater;

import com.jpmc.theater.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTests {
    @Test
    void testTicketPrice() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        Showing showing = new Showing(spiderMan, 5, time);

        Ticket ticket = new Ticket(new Discount());

        assertEquals(10.0, ticket.calculateTicketPrice(showing));
    }

    @Test
    void testTicketPriceWithNoDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        Showing showing = new Showing(spiderMan, 5, time);

        Ticket ticket = new Ticket(new Discount());

        assertEquals(12.5, ticket.calculateTicketPrice(showing));
    }
}
