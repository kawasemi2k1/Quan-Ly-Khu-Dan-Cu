/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.object;

/**
 *
 * @author APC
 */
public class LichHoatDong {
    private String maLich;
    private String CMND;
    private String thoiGian;
    private String congViec;
    private String trangThai;

    public LichHoatDong(String maLich, String CMND, String thoiGian, String congViec, String trangThai) {
        this.maLich = maLich;
        this.CMND = CMND;
        this.thoiGian = thoiGian;
        this.congViec = congViec;
        this.trangThai = trangThai;
    }

    public LichHoatDong() {
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
