package com.hotelreservation;

import com.hotelreservation.services.HotelOperations;
import com.hotelreservation.services.IHotelOperations;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void givenHotelNameAndRate_WhenAddedToList_ShouldReturnNumberOfHotels() {
        IHotelOperations hotelOperations = new HotelOperations();

        hotelOperations.addHotels("Lakewood", 110);
        hotelOperations.addHotels("Bridgewood", 160);
        hotelOperations.addHotels("Ridgewood", 220);

        Assert.assertEquals(3, hotelOperations.getNumberOfHotels());

    }
}
