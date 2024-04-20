/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "LoaiKhuyenMaiEntity.getAllLoaiKhuyenMai", query = "SELECT lkm FROM LoaiKhuyenMaiEntity lkm"),
})
public class LoaiKhuyenMaiEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2758145462323032003L;
	@Id
    @Column(name = "maLoaiKM")
    private String maLoaiKM;
	@Column(name = "moTa", columnDefinition = "nvarchar(255)")
    private String moTa;

    public LoaiKhuyenMaiEntity(String maLoaiKM, String moTa) {
        this.maLoaiKM = maLoaiKM;
        this.moTa = moTa;
    }

    public LoaiKhuyenMaiEntity() {
    }

    public LoaiKhuyenMaiEntity(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }
    
    
    public String getMaLoaiKM() {
        return maLoaiKM;
    }

    public void setMaLoaiKM(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
