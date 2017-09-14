package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class db {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/sweety_db?"
                + "user=sweety&password=tt736974&useUnicode=true&characterEncoding=UTF8";
	private static String user="sweety";
	private static String pwd="tt123456";
	public static Connection getconnection(){
		Connection conn=null;
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
}
