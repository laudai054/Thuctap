package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception{
	
			//B1: xac dinh hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-G30M9MA:1433;databaseName=NIKE;user=sa; password=123456");
		System.out.println("Da ket noi");
	}
}
