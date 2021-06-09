package com.hotelreservation.entity;

public class Hotels {

    private String hotelName;
    private int hotelWeekRate;
    private int hotelWeekEndRate;

    public Hotels(String hotelName, int hotelWeekRate, int hotelWeekEndRate) {
        this.hotelName = hotelName;
        this.hotelWeekRate = hotelWeekRate;
        this.hotelWeekEndRate = hotelWeekEndRate;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public int getHotelWeekRate() {
        return hotelWeekRate;
    }
    public void setHotelWeekRate(int hotelWeekRate) {
        this.hotelWeekRate = hotelWeekRate;
    }
    public int getHotelWeekEndRate() {
        return hotelWeekEndRate;
    }
    public void setHotelWeekEndRate(int hotelWeekEndRate) {
        this.hotelWeekEndRate = hotelWeekEndRate;
    }
}
