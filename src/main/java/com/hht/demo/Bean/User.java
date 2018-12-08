package com.hht.demo.Bean;

public class User {
	private String username;
	private String password;
	private String memo;
	private String tel;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", memo=" + memo + ", tel=" + tel + ", email=" + email + "]";
	}

	public User(String username, String password, String memo, String tel, String email) {
		this.username = username;
		this.password = password;
		this.memo = memo;
		this.tel = tel;
		this.email = email;
	}

	public User() {
	}
}
