package com.velan.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Properties")
public class Properties {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Property Id")
	private int pid;
	@Column(name="Address")
	private String address;
	@Column(name="Type")
	private String type;
	@Column(name="Status")
	private String status;
	

	public Properties() {
		super();
	}


	public Properties(int pid, String address, String type, String status) {
		super();
		this.pid = pid;
		this.address = address;
		this.type = type;
		this.status = status;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Properties [pid=" + pid + ", address=" + address + ", type=" + type + ", status=" + status + "]";
	}

	
}
