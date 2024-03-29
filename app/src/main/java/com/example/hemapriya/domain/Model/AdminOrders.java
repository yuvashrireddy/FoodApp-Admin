package com.example.hemapriya.domain.Model;

public class AdminOrders
{
    private String name, state, phone, address, date,  totalAmount;

    public AdminOrders(String name, String state, String phone, String address, String date,String totalAmount) {
        this.name = name;
        this.state = state;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public AdminOrders() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
