package com.hotelreservation.services;

import com.hotelreservation.controller.Output;
import com.hotelreservation.entity.CustomerType;
import com.hotelreservation.entity.Hotels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class HotelOperations implements IHotelOperations {

    private List<Hotels> hotels;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("ddMMMyyy");

    public HotelOperations() {
        this.hotels = new ArrayList<>();
    }


    @Override
    public boolean addHotels(Hotels hotel) {
        return this.hotels.add(hotel);
    }

    @Override
    public int getNumberOfHotels() {
        return this.hotels.size();
    }


    @Override
    public List<Output> findCheapHotel(CustomerType customerType, String date1, String date2) {
        LocalDate initialDate = LocalDate.parse(date1, DATE_TIME_FORMATTER);
        LocalDate endDate = LocalDate.parse(date2, DATE_TIME_FORMATTER);

        List<Output> outputs = this.hotels.stream()
                .map(hotel -> {
                    Output output = new Output();
                    output.setHotelName(hotel.getHotelName());
                    output.setTotalRate(hotel.getTotalRate(customerType, initialDate, endDate));
                    return output;
                })
                .sorted(Comparator.comparing(Output :: getTotalRate))
                .collect(Collectors.toList());

        return outputs.stream()
                .filter(output -> output.getTotalRate() == outputs.get(0).getTotalRate())
                .collect(Collectors.toList());
    }

    @Override
    public List<Output> findCheapBestRatedHotel(CustomerType customerType, String date1, String date2) {
        LocalDate initialDate = LocalDate.parse(date1, DATE_TIME_FORMATTER);
        LocalDate endDate = LocalDate.parse(date2, DATE_TIME_FORMATTER);

        List<Output> outputs = this.hotels.stream()
                .map(hotel -> {
                    Output output = new Output();
                    output.setHotelName(hotel.getHotelName());
                    output.setHotelRating(hotel.getRating());
                    return output;
                })
                .sorted(Comparator.comparing(Output :: getTotalRate).thenComparing(Output :: getHotelRating))
                .collect(Collectors.toList());

        return outputs.stream()
                .filter(output ->
                        output.getTotalRate() == outputs.get(0).getTotalRate()
                && output.getHotelRating() == outputs.get(0).getHotelRating())
                .collect(Collectors.toList());
    }
}
