package com.example.mp3app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChuDeVaTheLoai {

    @SerializedName("TheLoai")
    @Expose
    private List<TheLoai> theLoai = null;
    @SerializedName("ChuDe")
    @Expose
    private List<ChuDe> chuDe = null;

    public List<TheLoai> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(List<TheLoai> theLoai) {
        this.theLoai = theLoai;
    }

    public List<ChuDe> getChuDe() {
        return chuDe;
    }

    public void setChuDe(List<ChuDe> chuDe) {
        this.chuDe = chuDe;
    }

}