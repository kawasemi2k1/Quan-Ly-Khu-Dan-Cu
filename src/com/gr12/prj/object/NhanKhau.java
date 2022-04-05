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
public class NhanKhau {
    private String maNK;
    private String soHoKhau;
    private String hoTen;
    private String gioiTinh;
    private String sinhNhat;
    private String noiSinh;
    private String nguyenQuan; // nơi ông nội sinh (khai sinh theo họ cha), or nơi bông bà ngoại sinh (khai sinh theo họ mẹ)
    private String danToc;
    private String ngheNghiep;
    private String noiLamViec;
    private String soCMND;
    private String ngayNoiCapCMND; // ngày và nơi cấp CMND
    private String thoiGianDKThuongTru; // ngày tháng năm
    private String diaChiTruoc; // địa chỉ trước khi chuyển đến
    private String quanHeVoiChuHo;
    private String ghiChu;

    public NhanKhau() {
    }

    public NhanKhau(String maNK, String soHoKhau, String hoTen, String gioiTinh, String sinhNhat, String noiSinh, String nguyenQuan, String danToc, String ngheNghiep, String noiLamViec, String soCMND, String ngayNoiCapCMND, String thoiGianDKThuongTru, String diaChiTruoc, String quanHeVoiChuHo, String ghiChu) {
        this.maNK = maNK;
        this.soHoKhau = soHoKhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sinhNhat = sinhNhat;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.soCMND = soCMND;
        this.ngayNoiCapCMND = ngayNoiCapCMND;
        this.thoiGianDKThuongTru = thoiGianDKThuongTru;
        this.diaChiTruoc = diaChiTruoc;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.ghiChu = ghiChu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

   

    public String getMaNK() {
        return maNK;
    }

    public void setMaNK(String maNK) {
        this.maNK = maNK;
    }

 

    public String getSoHoKhau() {
        return soHoKhau;
    }

    public void setSoHoKhau(String soHoKhau) {
        this.soHoKhau = soHoKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSinhNhat() {
        return sinhNhat;
    }

    public void setSinhNhat(String sinhNhat) {
        this.sinhNhat = sinhNhat;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getNgayNoiCapCMND() {
        return ngayNoiCapCMND;
    }

    public void setNgayNoiCapCMND(String ngayNoiCapCMND) {
        this.ngayNoiCapCMND = ngayNoiCapCMND;
    }

    public String getThoiGianDKThuongTru() {
        return thoiGianDKThuongTru;
    }

    public void setThoiGianDKThuongTru(String thoiGianDKThuongTru) {
        this.thoiGianDKThuongTru = thoiGianDKThuongTru;
    }

    public String getDiaChiTruoc() {
        return diaChiTruoc;
    }

    public void setDiaChiTruoc(String diaChiTruoc) {
        this.diaChiTruoc = diaChiTruoc;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
