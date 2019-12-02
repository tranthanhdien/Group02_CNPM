package com.example.mp3app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


// lớp này chứa các thuộc tính được sinh ra từ dữ liệu JSON nhận đc
public class PlayList implements Serializable { // danh sách các bài hát

    @SerializedName("IdPlayList")
    @Expose
    private String idPlayList;
    @SerializedName("Ten")
    @Expose
    private String ten;
    @SerializedName("HinhPlayList")
    @Expose
    private String hinhPlayList;
    @SerializedName("Icon")
    @Expose
    private String icon;

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhPlayList() {
        return hinhPlayList;
    }

    public void setHinhPlayList(String hinhPlayList) {
        this.hinhPlayList = hinhPlayList;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}