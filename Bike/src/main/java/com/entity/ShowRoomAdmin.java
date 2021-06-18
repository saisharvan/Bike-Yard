package com.entity;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="showroomadmin")
	public class ShowRoomAdmin {
		@Column(name="userName")
		private String userName;
		
		@Column(name="email")
		String email;
		
		@Column(name="password")
		private String password;
		
		@Column(name="showRoomName")
	    private String showRoomName;
		
		@Column(name="showRoomAddress")
	    private String showRoomAddress;
		
		@Column(name="showRoomLocation")
	    private String showRoomLocation;
		
		@Id
		@Column(name="showRoomId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer showRoomId;
		
		
		public ShowRoomAdmin() {}
		
		
		public Integer getShowRoomId() {
			return showRoomId;
		}
		public void setShowRoomId(Integer showRoomId) {
			this.showRoomId = showRoomId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getShowRoomName() {
			return showRoomName;
		}
		public void setShowRoomName(String showRoomName) {
			this.showRoomName = showRoomName;
		}
		public String getShowRoomAddress() {
			return showRoomAddress;
		}
		public void setShowRoomAddress(String showRoomAddress) {
			this.showRoomAddress = showRoomAddress;
		}

		public String getShowRoomLocation() {
			return showRoomLocation;
		}
		public void setShowRoomLocation(String showRoomLocation) {
			this.showRoomLocation = showRoomLocation;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	}


