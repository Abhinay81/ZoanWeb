package com.zoan.service;

import java.util.List;

import com.zoan.dto.CartDTO;
import com.zoan.dto.UserDTO;
import com.zoan.entity.Cart;
import com.zoan.entity.User;
import com.zoan.exception.ZoanException;

public interface CartAllocationService {
	
	public Cart addToCart(CartDTO cartDTO) throws ZoanException;

    public List<Cart> getCartItemsByEmail(String userEmail) throws ZoanException;

    public boolean isUserExists(String emailId) throws ZoanException;

    public User addUser(UserDTO userDTO) throws ZoanException;
    
    public User getUserByEmail(String emailId) throws ZoanException;

}
