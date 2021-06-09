package com.hotelreservation.services;

import com.hotelreservation.entity.Hotels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelOperations implements IHotelOperations {

    List<Hotels> hotels = new ArrayList<>();

    @Override
    public void addHotels(String hotelName, int hotelWeekRate, int hotelWeekEndRate) {
        hotels.add(new Hotels(hotelName, hotelWeekRate, hotelWeekEndRate));
    }

    @Override
    public int getNumberOfHotels() {
        return this.hotels.size();
    }

    @SafeVarargs
    @Override
    public final <E> Hotels findCheapHotel(E... dates) {
        List<E> datesArray = Arrays.asList(dates);
        Hotels hotel = hotels.get(0);

        for (Hotels value : hotels) {
            if (hotel.getHotelWeekRate() > value.getHotelWeekRate())
                hotel = value;
        }

        return new Hotels(hotel.getHotelName(), datesArray.size() * hotel.getHotelWeekRate(), hotel.getHotelWeekEndRate());
    }
}
