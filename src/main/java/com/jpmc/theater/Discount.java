package com.jpmc.theater;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.jpmc.theater.constants.MovieCodes.*;

public class Discount {
    public double getDiscount(Showing showing) {
        int showSequence = showing.getSequenceOfTheDay();
        int specialCode = showing.getMovie().getSpecialCode();
        double ticketPrice = showing.getMovie().getTicketPrice();
        LocalDateTime startingTime = showing.getStartTime();

        // find all discount customer is eligible for
        double specialDiscount = getSpecialDiscount(specialCode, ticketPrice);
        double sequenceDiscount = getSequenceDiscount(showSequence);
        double timeDiscount = getTimeDiscount(LocalTime.from(startingTime), ticketPrice);
        double dateDiscount = getDateDiscount(startingTime, ticketPrice);

        // biggest discount wins
        double dateTimeDiscount = Math.max(timeDiscount, dateDiscount);
        return Math.max(Math.max(specialDiscount, sequenceDiscount), dateTimeDiscount);
    }

    public double getSpecialDiscount(int specialCode, double ticketPrice) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        return specialDiscount;
    }

    public double getSequenceDiscount(int showSequence) {
        switch (showSequence) {
            case 1:
                return 3; // $3 discount for 1st show
            case 2:
                return 2; // $2 discount for 2nd show
            default:
                return 0;
        }
    }

    public double getTimeDiscount(LocalTime showStartTime, double ticketPrice) {
        boolean canGetTimeDiscount = showStartTime.isAfter(MOVIE_START_TIME_FOR_DISCOUNT) && showStartTime.isBefore(MOVIE_END_TIME_FOR_DISCOUNT);
        double timeDiscount = 0;
        if (canGetTimeDiscount) {
            timeDiscount = ticketPrice * TIME_DISCOUNT;
        }
        return timeDiscount;
    }

    public double getDateDiscount(LocalDateTime startDate, double ticketPrice) {
        int day = startDate.getDayOfMonth();

        if (day == DAY_FOR_DISCOUNT) {
            return DISCOUNT_FOR_DAY;
        }
        return 0;
    }
}
