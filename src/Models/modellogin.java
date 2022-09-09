package Models;

public class modellogin {
	

	
		
		int Id;
		String name;
		
		
		
		String adddress;
		String email;
		
		String mobile;
		String password;
	
		
		public modellogin() {
			
			this.Id = 0;
			this.name = "";
			this.adddress = "";
			this.email = "";
			this.mobile = "";
			this.password = "";
		}
		public modellogin(int id, String name, String adddress, String email, String mobile, String password) {
			super();
			Id = id;
			this.name = name;
			this.adddress = adddress;
			this.email = email;
			this.mobile = mobile;
			this.password = password;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAdddress() {
			return adddress;
		}
		public void setAdddress(String adddress) {
			this.adddress = adddress;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}


	


	}
	