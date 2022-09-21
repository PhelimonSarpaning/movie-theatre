package com.jpmc.theater;

public class Ticket {

    private final Discount discount;

    public Ticket(Discount discount) {
        this.discount = discount;
    }

    public double calculateTicketPrice(Showing showing) {
        return showing.getMovie().getTicketPrice() - discount.getDiscount(showing);
    }
}
