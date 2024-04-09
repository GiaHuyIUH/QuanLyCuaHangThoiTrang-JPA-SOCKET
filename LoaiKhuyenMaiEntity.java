package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiKhuyenMai")
public class LoaiKhuyenMaiEntity {
    
    @Id
    @Column(name = "maLoaiKM")
    private String maLoaiKM;
    
    @Column(name = "moTa")
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
    
    // Getters and setters

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
