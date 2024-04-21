/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entity;

/**
 *
 * @author Nguyen Huy Hoang
 */
public enum TinhTrangHDEnum {
    DATHANHTOAN("Đã Thanh Toán"), CHUATHANHTOAN("Chưa Thanh Toán");
    
    private String name;
    private TinhTrangHDEnum(String name) {
        this.name = name;
    }
    @Override
	public String toString() {
		return name;
	}
}
