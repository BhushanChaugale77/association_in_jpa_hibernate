package com.prowings.one_to_one_bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@Column(name = "Acc_id")
	private int id;
	@Column
	private long accountNo;
	@Column
	private String accountName;
	@OneToOne
	private Employee employee;

	public Account() {
		super();
 	}

	public Account(long accountNo, String accountName, Employee employee) {
		super();
 		this.accountNo = accountNo;
		this.accountName = accountName;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNo=" + accountNo + ", accountName=" + accountName + ", employee="
				+ employee + "]";
	}
	
	
	
	
	
}
