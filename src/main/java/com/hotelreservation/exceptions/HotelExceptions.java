package com.hotelreservation.exceptions;

public class HotelExceptions extends RuntimeException{
    public ExceptionType exceptionType;

    public enum ExceptionType{
        INVALID_DATE_RANGE("Enter Proper Date Range."),
        INVALID_DATE_FORMAT("Enter Proper Date format.");
        public String message;

        ExceptionType(String message){
            this.message = message;
        }
    }

    public HotelExceptions(ExceptionType exceptionType){
        super(exceptionType.message);
        this.exceptionType = exceptionType;
    }

}
