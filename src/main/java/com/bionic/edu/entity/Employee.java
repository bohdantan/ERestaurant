package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String address;
	private String email;
	private String phone;
	private java.sql.Date birthDate;
	private boolean activated;
	private boolean administrator;
	private boolean kitchenStaff;
	private boolean deliveryStaff;
	private boolean businessAnalyst;
	private boolean sequrityOfficer;
	
	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.sql.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public boolean isKitchenStaff() {
		return kitchenStaff;
	}

	public void setKitchenStaff(boolean kitchenStaff) {
		this.kitchenStaff = kitchenStaff;
	}

	public boolean isDeliveryStaff() {
		return deliveryStaff;
	}

	public void setDeliveryStaff(boolean deliveryStaff) {
		this.deliveryStaff = deliveryStaff;
	}

	public boolean isBusinessAnalyst() {
		return businessAnalyst;
	}

	public void setBusinessAnalyst(boolean businessAnalyst) {
		this.businessAnalyst = businessAnalyst;
	}

	public boolean isSequrityOfficer() {
		return sequrityOfficer;
	}

	public void setSequrityOfficer(boolean sequrityOfficer) {
		this.sequrityOfficer = sequrityOfficer;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password="
				+ password + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + ", birthDate=" + birthDate
				+ ", activated=" + activated + ", administrator="
				+ administrator + ", kitchenStaff=" + kitchenStaff
				+ ", deliveryStaff=" + deliveryStaff + ", businessAnalyst="
				+ businessAnalyst + ", sequrityOfficer=" + sequrityOfficer
				+ "]";
	}
	
}
