package com.example.hemapriya.domain;

class User {

    String name; String phone; String addr;
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User(String name, String phone, String addr) {
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }
}
