package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class connroom {
  
	public ArrayList roomdata() {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList array= new ArrayList();
		String query = "select * from room where roomstatus='available'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement","root","");
			ps= conn.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				modelroom room= new modelroom(rs.getInt("roomnumber"),
						rs.getString("typeofroom"),
						rs.getInt("roomprice"),
						rs.getString("roomstatus"));
				array.add(room);
			}
		}catch (Exception ex) {
			System.out.println("error");
		}
		return array;
	}
	
	public boolean update(modelroom room) {
		Connection conn;
		PreparedStatement ps;
		String query = "update room set roomstatus= ? where roomnumber=?";
		boolean result =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement","root","");
			ps=conn.prepareStatement(query);
			ps.setString(1,room.getRoomstatus());
			ps.setDouble(2, room.getRoomnumber());
			ps.executeUpdate();
			ps.close();
			result=true;
			
		}catch(Exception ex) {
			System.out.println("error");
		}return result;
	}
}
