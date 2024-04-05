package com.prowings.one_to_many_bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Acc_id")
	private int id;
	@Column
	private int accountNumber;
	@Column
	private String accountName;

//	private Employee employee;

	public Account() {
		super();
	}

	public Account(int accountNumber, String accountName/*, Employee employee*/) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
	//	this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	
	
	
	
	
}
