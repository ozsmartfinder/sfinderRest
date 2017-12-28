package com.SfinderRest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="UserInfo")
public class UserInfo {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Id", updatable=false, insertable = false)
	private int Id;
	@javax.persistence.Id
	@Column(name="Username", updatable=false)
	private String Username;
	private String Password;
	private String Phone;
	private String Email;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	

}
