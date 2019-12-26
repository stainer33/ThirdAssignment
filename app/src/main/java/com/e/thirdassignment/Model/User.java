package com.e.thirdassignment.Model;

public class User {
    private String name;
    private int age;
    private String address;
    private int imgId;


    public User(String name, int age, String address, int imgId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.imgId = imgId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
