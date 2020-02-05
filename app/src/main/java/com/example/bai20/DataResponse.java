package com.example.bai20;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("elements")
    private List<UserModel> users;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public String getStatus() {
        return status;
    }

    public List<UserModel> getUsers() {
        return users;
    }
}
