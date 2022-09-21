package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.utils.LocalDateProvider;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.jpmc.theater.TestData.provider;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {
    Theater theater = new Theater(LocalDateProvider.singleton());
    Customer john = new Customer("John Doe", "id-12345");

    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );

        assertTrue(new Reservation(customer, showing, 3).getTotalFee() == 28.5);
    }

    @Test
    void totalFeeForCustomer() {
        Reservation reservation = Reservation.reserve(john, 2, 4, theater.getTheaterSchedule(TestData.TEST_SCHEDULE));
        System.out.println("You have to pay " + reservation.getTotalFee());
        assertEquals(reservation.getTotalFee(), 40);
    }

    @Test
    void totalFeeForCustomerWithMovieShowingWithinDiscountHrs() {
        Reservation reservation = Reservation.reserve(john, 3, 4, theater.getTheaterSchedule(TestData.TEST_SCHEDULE));
        System.out.println("You have to pay " + reservation.getTotalFee());
        assertEquals(reservation.getTotalFee(), 27);
    }

    @Test
    void totalFeeForCustomerWithMovieShowingOn7th() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        List<Showing> TEST_SCHEDULE = List.of(
                new Showing(turningRed, 1, LocalDateTime.of(LocalDate.parse("2022-09-07"), LocalTime.of(9, 0))),
                new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
                new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
                new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
                new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.parse("2022-09-07"), LocalTime.of(16, 10)))
        );
        Reservation reservation = Reservation.reserve(john, 5, 4, theater.getTheaterSchedule(TEST_SCHEDULE));
        System.out.println("You have to pay " + reservation.getTotalFee());
        assertEquals(reservation.getTotalFee(), 46);
    }
}
