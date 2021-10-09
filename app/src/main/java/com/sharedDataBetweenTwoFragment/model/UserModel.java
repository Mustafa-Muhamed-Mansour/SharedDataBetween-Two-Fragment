package com.sharedDataBetweenTwoFragment.model;

public class UserModel
{

    String name;
    String phone;

    public UserModel()
    {
    }

    public UserModel(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
