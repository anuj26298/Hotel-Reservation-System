package com.hotelreservation.services;

import com.hotelreservation.entity.Hotels;

import java.util.ArrayList;
import java.util.List;

public class HotelOperations implements IHotelOperations {

    List<Hotels> hotels = new ArrayList<>();

    @Override
    public void addHotels(String hotelName, int hotelRate) {
        hotels.add(new Hotels(hotelName, hotelRate));
    }

    @Override
    public int getNumberOfHotels() {
        return this.hotels.size();
    }
}
