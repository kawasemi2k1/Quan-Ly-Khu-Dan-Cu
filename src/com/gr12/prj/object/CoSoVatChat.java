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
public class CoSoVatChat {
    private String ten;
    private String soLuong;
    private String trangThai;
    private String ghiChu;

    public CoSoVatChat() {
    }

    public CoSoVatChat(String ten, String soLuong, String trangThai, String ghiChu) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
