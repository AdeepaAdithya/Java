/* file name            :- BankService.java
 * Author               :- A.A.G
 * Created/Updated Date :- 22/06/2025
 * Version              :- java 24.0.1
 * Description          :- This code will be the use for object creation.
 */
package com.jdbc.domain;

public class Bank {
	
	// Assigning the variables.
	private long bankId;
	private String code;
	private String name;
	private String status;
	private int totalStaff;
	private int totalBranch;
	
	
	//getters and setters
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long l) {
		this.bankId = l;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalStaff() {
		return totalStaff;
	}
	public void setTotalStaff(int totalStaff) {
		this.totalStaff = totalStaff;
	}
	public int getTotalBranch() {
		return totalBranch;
	}
	public void setTotalBranch(int totalBranch) {
		this.totalBranch = totalBranch;
	}
	//making the to string method.(use when need the select option.)
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", code=" + code + ", name=" + name + ", status=" + status + ", totalStaff="
				+ totalStaff + ", totalBranch=" + totalBranch + "]";
	}
	
	
	
	
}
