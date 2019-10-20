package com.nt.model;

public class Employee {
	private Integer eNo;
	private String eName;
	private String desg;
	private String gender;
	private String email;
	private String date;
	private Long mobile;

	public Employee() {
		super();
	}

	public Employee(Integer eNo, String eName, String desg, String gender, String email, String date, Long mobile) {
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
		return "Employee [eNo=" + eNo + ", eName=" + eName + ", desg=" + desg + ", gender=" + gender + ", email="
				+ email + ", date=" + date + ", mobile=" + mobile + "]";
	}

}
