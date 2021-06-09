package com.hotelreservation.services;

import com.hotelreservation.entity.Hotels;

public interface IHotelOperations {

     void addHotels(String hotelName, int hotelWeekRate, int hotelWeekEndRate);
     int getNumberOfHotels();
     <E> Hotels findCheapHotel(E... dates);
}
