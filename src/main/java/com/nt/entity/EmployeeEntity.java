package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_info")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer eNo;
	@Column
	private String eName;
	@Column
	private String desg;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private String date;
	@Column
	private Long mobile;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(Integer eNo, String eName, String desg, String gender, String email, String date,
			Long mobile) {
		super();
		this.eNo = eNo;
		this.eName = eName;
		this.desg = desg;
		this.gender = gender;
		this.email = email;
		this.date = date;
		this.mobile = mobile;
	}

	public Integer geteNo() {
		return eNo;
	}

	public void seteNo(Integer eNo) {
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [eNo=" + eNo + ", eName=" + eName + ", desg=" + desg + ", gender=" + gender + ", email="
				+ email + ", date=" + date + ", mobile=" + mobile + "]";
	}

}
