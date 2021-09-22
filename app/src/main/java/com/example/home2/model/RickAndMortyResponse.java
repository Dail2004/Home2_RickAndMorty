package com.example.home2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RickAndMortyResponse<T> {

    @SerializedName("info")
    private Info info;

    @SerializedName("result")
    private ArrayList<T> result;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<T> getResult() {
        return result;
    }

    public void setResult(ArrayList<T> result) {
        this.result = result;
    }
}
