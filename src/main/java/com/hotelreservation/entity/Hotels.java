package com.hotelreservation.entity;

public class Hotels {

    private String hotelName;
    private int hotelRate;

    public Hotels(String hotelName, int hotelRate) {
        this.hotelName = hotelName;
        this.hotelRate = hotelRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRate() {
        return hotelRate;
    }

    public void setHotelRate(int hotelRate) {
        this.hotelRate = hotelRate;
    }
}
