package com.SfinderRest.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="DeviceInfo")
//@IdClass(DeviceInfoKey.class)  
public class DeviceInfo {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Id", updatable=false, insertable = false) //to prevent hibernate update & insert Id, dealt in db level
	private int Id;
	@javax.persistence.Id
	@Column(name="DevId", unique = true)  
	private String DevId;
	private Double Lon;
	private Double Lat;
	private Double Apt;
	private Timestamp Time;
	@Column(name="Username", updatable=false)  //this information is fixed so not updatable
	private String Username;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDevId() {
		return DevId;
	}
	public void setDevId(String devId) {
		DevId = devId;
	}
	public Double getLon() {
		return Lon;
	}
	public void setLon(Double lon) {
		Lon = lon;
	}
	public Double getLat() {
		return Lat;
	}
	public void setLat(Double lat) {
		Lat = lat;
	}
	public Double getApt() {
		return Apt;
	}
	public void setApt(Double apt) {
		Apt = apt;
	}
	public Timestamp getTime() {
		return Time;
	}
	public void setTime(Timestamp time) {
		Time = time;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
}
