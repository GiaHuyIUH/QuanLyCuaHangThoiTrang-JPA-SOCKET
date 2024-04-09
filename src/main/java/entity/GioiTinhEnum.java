/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entity;

/**
 *
 * @author HUY
 */
public enum GioiTinhEnum {
    NAM("Nam"), NU("Nữ"), KHAC("Khác");
	
	private String name;
	
	private GioiTinhEnum(String name) {
		this.name = name;
	}
    
    @Override
    public String toString() {
        return name;
    }
    
}
