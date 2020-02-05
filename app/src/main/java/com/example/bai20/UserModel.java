package com.example.bai20;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Retrofit;

public class UserModel {
    @SerializedName("TYPE")
    private String type;
    @SerializedName("FO100")
    private int fo100;
    @SerializedName("NV106")
    private String nv106;
    @SerializedName("NV107")
    private int nv107;
    @SerializedName("FN601")
    private int fn601;
    @SerializedName("AVATAR")
    private String avatar;

    public String getType() {
        return type;
    }

    public int getFo100() {
        return fo100;
    }

    public String getNv106() {
        return nv106;
    }

    public int getNv107() {
        return nv107;
    }

    public int getFn601() {
        return fn601;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserModel(String type, int fo100, String nv106, int nv107, int fn601, String avatar) {
        this.type = type;
        this.fo100 = fo100;
        this.nv106 = nv106;
        this.nv107 = nv107;
        this.fn601 = fn601;
        this.avatar = avatar;
    }
}
