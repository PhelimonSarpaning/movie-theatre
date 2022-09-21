package com.jpmc.theater;

import com.jpmc.theater.model.Customer;

import java.util.List;

public class Reservation {
    private final Showing showing;
    private final int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public static Reservation reserve(Customer customer, int sequence, int howManyTickets, List<Showing> schedule) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    public double getTotalFee() {
        return showing.calculateFee(audienceCount);
    }
}
