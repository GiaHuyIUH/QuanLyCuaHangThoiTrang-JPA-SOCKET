/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.ChatLieuEntity;

import java.rmi.RemoteException;
import java.util.ArrayList;




/**
 *
 * @author Tran Hien Vinh
 */
public interface ChatLieu_Interface extends java.rmi.Remote {
    public ArrayList<ChatLieuEntity> getAllCL()throws java.rmi.RemoteException;
    public String layTenChatLieuTheoMa(String maChatLieu)throws java.rmi.RemoteException;
    public String layMaChatLieuTheoTen(String tenChatLieu)throws java.rmi.RemoteException;
	boolean themChatLieu(ChatLieuEntity cl) throws RemoteException;
}
