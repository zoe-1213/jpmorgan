package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        System.out.println("You have to pay " + reservation.totalFee());
        assertEquals(reservation.totalFee(), 50);
    }

    @Test
    void hourDiscountTest() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 4, 1);
        System.out.println("You have to pay " + reservation.totalFee());
        assertEquals(reservation.totalFee(), 11 * 0.75);
    }

    @Test
    void sequenceDiscount() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 1, 1);
        System.out.println("You have to pay " + reservation.totalFee());
        assertEquals(reservation.totalFee(), 11 - 3);
        Reservation reservation1 = theater.reserve(john, 7, 1);
        System.out.println("You have to pay " + reservation1.totalFee());
        assertEquals(reservation1.totalFee(), 11 - 1);
    }




    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
