package com.example.bai20;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("elements")
    private List<UserModel> elements;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserModel> getElements() {
        return elements;
    }

    public void setElements(List<UserModel> elements) {
        this.elements = elements;
    }
}
