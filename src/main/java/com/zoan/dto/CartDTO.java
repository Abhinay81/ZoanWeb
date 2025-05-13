package com.zoan.dto;

import lombok.Data;

@Data
public class CartDTO {
	private Integer id;

    private String itemId;
    private String name;
    private String description;
    private String image;

    private String userEmail;
}
