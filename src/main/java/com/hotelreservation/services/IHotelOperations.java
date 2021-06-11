package com.hotelreservation.services;

import com.hotelreservation.controller.Output;
import com.hotelreservation.entity.CustomerType;
import com.hotelreservation.entity.Hotels;

import java.util.List;

public interface IHotelOperations {

     boolean addHotels(Hotels hotels);
     int getNumberOfHotels();
     List<Output> findCheapHotel(CustomerType customerType, String date1, String date2);
     List<Output> findCheapBestRatedHotel(CustomerType customerType, String date1, String date2);
}
