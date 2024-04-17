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
    DATHANHTOAN("Da Thanh Toan"), CHUATHANHTOAN("Chua Thanh Toan");

//    @Override
//    public String toString() {
//        switch (this) {
//            case DATHANHTOAN:
//                return "Đã thanh toán";
//            case CHUATHANHTOAN:
//                return "Chưa thanh toán";
//            default:
//                return "Chưa thanh toán";
//        }
//    }
    
    private String name;
    private TinhTrangHDEnum(String name) {
        this.name = name;
    }
    @Override
	public String toString() {
		return name;
	}
}
