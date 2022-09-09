package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connLogin {
	
	final String Driver="com.mysql.cj.jdbc.Driver";		
	final String DBNAME="hotelmanegement";
	final String HOST="localhost";
	final int PORT =3306;
	final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
	final String USER ="root";
	final String PASSWORD="";
	
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(Driver);   //loading driver
			conn=DriverManager.getConnection(URL,USER, PASSWORD);
		
		}
		
		catch (Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return conn;
		
	}
	
	public modellogin login(modellogin user) {
		String sql="SELECT * FROM customer WHERE email=? AND password=?";
		try {
			Connection conn=connect();
			if(conn!=null) {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1,user.getEmail());
			pstat.setString(2, user.getPassword());
			ResultSet rs=pstat.executeQuery();
			
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAdddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setPassword(rs.getString("password"));
				
			}
			}
			
		}
		catch(Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return user;
	}

}