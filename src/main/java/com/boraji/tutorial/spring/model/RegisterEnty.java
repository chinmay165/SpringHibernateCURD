package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="reg_tbl")
public class RegisterEnty {
	@Id
	@GeneratedValue
	@Column(name="reg_id")
	private long regId;
	
	@Column(name="name")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String name;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="email")
	private String email;
	
	@Column(name="addr")
	private String addr;

	public long getRegId() {
		return regId;
	}

	public void setRegId(long regId) {
		this.regId = regId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	

}
