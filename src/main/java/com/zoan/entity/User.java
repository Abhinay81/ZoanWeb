package com.zoan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private String emailId;
	private String name;
	private String collegeId;
	private Long phoneNo;
	private String password;
}
