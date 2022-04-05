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
public class SoHoKhau {
    private String soHoKhau; // số hộ khẩu
    private String hoTenChuHo;
    private String diaChi;

    public SoHoKhau(String soHoKhau, String hoTenChuHo, String diaChi) {
        this.soHoKhau = soHoKhau;
        this.hoTenChuHo = hoTenChuHo;
        this.diaChi = diaChi;
    }

    public SoHoKhau() {
    }

    public String getSoHoKhau() {
        return soHoKhau;
    }

    public void setSoHoKhau(String soHoKhau) {
        this.soHoKhau = soHoKhau;
    }

    public String getHoTenChuHo() {
        return hoTenChuHo;
    }

    public void setHoTenChuHo(String hoTenChuHo) {
        this.hoTenChuHo = hoTenChuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
