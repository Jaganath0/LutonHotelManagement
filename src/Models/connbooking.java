package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class connbooking {
	
	
	public boolean bookinginsert (modelbooking booking) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String query="INSERT INTO `booking`( `date`, `Checkindate`, `Checkoutdate`, `RoomType`, `Bookingstatus`, `id`) VALUES (?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement","root","");
			
			pstat=conn.prepareStatement(query);
			
			
			pstat.setString(1, booking.getDate());
			pstat.setString(2, booking.getCheckin());
			pstat.setString(3, booking.getCheckout());
			pstat.setString(4, booking.getRoomtype());
			pstat.setString(5, booking.getBookingstatus());
			pstat.setInt(6, GlobalVariable.lglobal.Id);
			
			
			pstat.executeUpdate();
			
			conn.close();
			pstat.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result;
		
	}
	
	
	
	
	
	public ArrayList show_table() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList array=new ArrayList();
		String sql="SELECT * FROM booking Where id=?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, GlobalVariable.lglobal.getId());
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				modelbooking booking=new modelbooking(rs.getInt("Bookingid"),
				        
						rs.getString("date"),
						rs.getString("checkindate"),
						rs.getString("checkoutdate"),
						rs.getString("RoomType"),
						rs.getString("Bookingstatus"),
						rs.getInt("id"),
						rs.getInt("roomnumber")
						);
				
				array.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return array;
		
	}
	
	
	public ArrayList manager_table() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList a1=new ArrayList();
		String sql="SELECT * FROM booking where Bookingstatus='Pending'";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement","root","");
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				modelbooking booking=new modelbooking(rs.getInt("bookingid"),
						rs.getString("date"),
						rs.getString("Checkindate"),
						rs.getString("Checkoutdate"),
						rs.getString("RoomType"),
						rs.getString("Bookingstatus"),
						rs.getInt("id"),
						rs.getInt("roomnumber")
						
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}
	
	
public boolean booking_update(modelbooking booking) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE booking SET roomnumber=?, Bookingstatus=? WHERE bookingid=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setInt(1, booking.getRoomnumber());
			pstat.setString(2, booking.getBookingstatus());
			pstat.setInt(3, booking.getBookingid());
			
			
			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result1=true;
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result1;
	}

}