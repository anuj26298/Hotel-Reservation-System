package com.hotelreservation.entity;

import com.hotelreservation.services.Rate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Hotels {

    private String hotelName;
    private int rating;
    private Map<CustomerType,Rate> HotelRate;


    public Hotels(String hotelName, int rating, HashMap<CustomerType, Rate> hotelRate) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.HotelRate = hotelRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Map<CustomerType, Rate> getHotelRate() {
        return HotelRate;
    }

    public void setHotelRate(Map<CustomerType, Rate> hotelRate) {
        HotelRate = hotelRate;
    }

    public int getTotalRate(CustomerType customerType, LocalDate date1, LocalDate  date2) {
        return Stream.iterate(date1, date -> date.plusDays(1))
                .limit(date2.getDayOfMonth() - date1.getDayOfMonth() + 1)
                .map(date -> {
                    if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                            date.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                        return this.HotelRate.get(customerType).getWeekEndRate();
                    return this.HotelRate.get(customerType).getWeekDayRate();
                }).reduce((totalRate,next) -> totalRate + next).get();
    }
}
