package com.app.entities;

import java.sql.Date;

public class Appointment {
	private String pname;
	private String dname;
	private Date doa;
	private String time;
	
	public Appointment(String pname, String dname, Date doa, String time) {
		super();
		this.pname = pname;
		this.dname = dname;
		this.doa = doa;
		this.time = time;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Date getDoa() {
		return doa;
	}

	public void setDoa(Date doa) {
		this.doa = doa;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Appointment [pname=" + pname + ", dname=" + dname + ", doa=" + doa + ", time=" + time + "]";
	}
	
	
}
