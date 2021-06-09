package com.hotelreservation;

import com.hotelreservation.entity.Hotels;
import com.hotelreservation.services.HotelOperations;
import com.hotelreservation.services.IHotelOperations;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void givenHotelNameAndRate_WhenAddedToList_ShouldReturnNumberOfHotels() {
        IHotelOperations hotelOperations = new HotelOperations();

        hotelOperations.addHotels("Lakewood", 110, 90);
        hotelOperations.addHotels("Bridgewood", 160, 50);
        hotelOperations.addHotels("Ridgewood", 220, 150);

        Assert.assertEquals(3, hotelOperations.getNumberOfHotels());
    }

    @Test
    public void givenHotelsWithRate_WhenCheckedForCheapestHotel_ReturnCheapestRated() {
        IHotelOperations hotelOperations = new HotelOperations();

        hotelOperations.addHotels("Lakewood", 110, 90);
        hotelOperations.addHotels("Bridgewood", 160, 50);
        hotelOperations.addHotels("Ridgewood", 220, 150);

        Hotels hotel = hotelOperations.findCheapHotel("10Sep2020", "11Sep2020");

        System.out.println(hotel.getHotelName());
        Assert.assertEquals(220, hotel.getHotelWeekRate());
    }
}
