package Models;

public class modelbooking {
	int bookingid;
	String date;
	String checkin;
	
	String checkout;
	String roomtype;
	String bookingstatus;
	int id;
	int roomnumber;
	
	public int getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public modelbooking() {
	
		this.bookingid = 0;
		this.date="";
		this.checkin = "";
		this.checkout = "";
		this.roomtype = "";
		this.bookingstatus ="" ;
		this.id= 0;
		this.roomnumber=0;
		
	}
	public modelbooking(int bookingid,String date, String checkin, String checkout, String roomtype, String bookingstatus,int id,int roomnumber) {

		this.bookingid = bookingid;
		this.date= date;
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomtype = roomtype;
		this.bookingstatus = bookingstatus;
		this.id= id;
		this.roomnumber= roomnumber;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

}
