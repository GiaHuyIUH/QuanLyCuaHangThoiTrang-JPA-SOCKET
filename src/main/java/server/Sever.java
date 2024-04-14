package server;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Sever {
	private static final String URL = "rmi://NguyenChung:7878/";
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
