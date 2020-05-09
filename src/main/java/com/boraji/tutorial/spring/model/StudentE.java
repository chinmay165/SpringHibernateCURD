package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="std_tbl")
public class StudentE {

	@Id
	@GeneratedValue
	@Column(name="card_id")
	private long cardid;
	
	@Column(name="roll_no")
	private long rollno;
	
	@Column(name="s_name")
	private String sname;
	
	@Column(name="stream")
	private String stream;
	
	public long getCardid() {
		return cardid;
	}
	public void setCardid(long cardid) {
		this.cardid = cardid;
	}
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	
}
