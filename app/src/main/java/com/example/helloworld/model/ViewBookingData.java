package com.example.helloworld.model;

public class ViewBookingData {
    String mem_name;
    String mem_nic;
    String hotel_name;
    String room_type;
    int no_of_rooms;
    double payment;
    String date;
    int bookingId;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public ViewBookingData(int bookingId, String date, String mem_name, String mem_nic, String hotel_name, String room_type, int no_of_rooms, double payment) {
        this.mem_name = mem_name;
        this.mem_nic = mem_nic;
        this.hotel_name = hotel_name;
        this.room_type = room_type;
        this.no_of_rooms = no_of_rooms;
        this.payment = payment;
        this.bookingId = bookingId;
        this.date = date;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_nic() {
        return mem_nic;
    }

    public void setMem_nic(String mem_nic) {
        this.mem_nic = mem_nic;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }




}

