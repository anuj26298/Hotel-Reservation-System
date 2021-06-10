package com.hotelreservation.services;

public class Rate implements Comparable{
    private Integer weekEndRate;
    private Integer weekDayRate;

    public Rate(int weekDayRate, int weekEndRate) {
        this.weekEndRate = weekEndRate;
        this.weekDayRate = weekDayRate;
    }

    public Integer getWeekEndRate() {
        return weekEndRate;
    }

    public Integer getWeekDayRate() {
        return weekDayRate;
    }

    @Override
    public int compareTo(Object o) {
        Rate rateObject = (Rate) o;
        return this.weekDayRate.compareTo(rateObject.getWeekDayRate());
    }
}
