package com.zoan.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String emailId;
	private String name;
	private String collegeId;
	private Long phoneNo;
	private String password; 
}
