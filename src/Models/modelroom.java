package Models;

public class modelroom {
	int roomnumber;
	String typeofroom;
	int roomprice ;
	String roomstatus;
	public modelroom() {
		
		this.roomnumber = 0;
		this.typeofroom = "";
		this.roomprice = 0;
		this.roomstatus = "";
	}
	public modelroom(int roomnumber, String typeofroom, int roomprice, String roomstatus) {
		super();
		this.roomnumber = roomnumber;
		this.typeofroom = typeofroom;
		this.roomprice = roomprice;
		this.roomstatus = roomstatus;
	}
	public int getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}
	public String getTypeofroom() {
		return typeofroom;
	}
	public void setTypeofroom(String typeofroom) {
		this.typeofroom = typeofroom;
	}
	public int getRoomprice() {
		return roomprice;
	}
	public void setRoomprice(int roomprice) {
		this.roomprice = roomprice;
	}
	public String getRoomstatus() {
		return roomstatus;
	}
	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

}
