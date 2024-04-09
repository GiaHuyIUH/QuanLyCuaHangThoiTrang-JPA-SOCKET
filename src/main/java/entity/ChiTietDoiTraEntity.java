/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ChiTietDoiTra")
public class ChiTietDoiTraEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaSP")
    private SanPhamEntity sanPham;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDT")
    private DoiTraEntity doiTra;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "GiaBan")
    private double giaBan;
    @Column(name = "ThanhTien")
    private double thanhTien;

    public ChiTietDoiTraEntity() {
    }

    public ChiTietDoiTraEntity(SanPhamEntity sanPham, DoiTraEntity doiTra, int soLuong, double giaBan, double thanhTien) {
        this.sanPham = sanPham;
        this.doiTra = doiTra;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public SanPhamEntity getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamEntity sanPham) {
        this.sanPham = sanPham;
    }

    public DoiTraEntity getDoiTra() {
        return doiTra;
    }

    public void setDoiTra(DoiTraEntity doiTra) {
        this.doiTra = doiTra;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietDoiTra{" + "sanPham=" + sanPham + ", doiTra=" + doiTra + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", thanhTien=" + thanhTien + '}';
    }
}
