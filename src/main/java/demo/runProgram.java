
package demo;

import java.rmi.RemoteException;

import gui.DangNhap_GUI;
import gui.TrangChu_GUI;

/**
 *
 * @author DELL
 */
public class runProgram {
    public static void main(String[] args) throws RemoteException {
        DangNhap_GUI dn = new DangNhap_GUI();
        dn.setVisible(true);
    
    }
    
}
