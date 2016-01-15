package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pms_token")
public class Token {
	
	@Id 
	@GeneratedValue
	private int id;
	@Column(name="token", unique = true)
    private String userTokenNo;
    @Column(name="type")
    private String type;
    
    public String getUserTokenNo() {
		return userTokenNo;
	}
	public void setUserTokenNo(String userTokenNo) {
		this.userTokenNo = userTokenNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	} 
	
    
    
    
	
	
}
