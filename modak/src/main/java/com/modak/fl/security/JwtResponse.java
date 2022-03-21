package com.modak.fl.security;

public class JwtResponse {

	private String token;
	//private String type;
	private String id;
	private String username;
	private String email;




	public JwtResponse(String token, /*String type,*/ String id, String username, String email) {
		super();
		this.token = token;
		//this.type = type;
		this.id = id;
		this.username = username;
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



}
