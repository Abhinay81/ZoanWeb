package com.zoan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoan.dto.CartDTO;
import com.zoan.dto.UserDTO;
import com.zoan.entity.Cart;
import com.zoan.entity.User;
import com.zoan.exception.ZoanException;
import com.zoan.repository.CartRepository;
import com.zoan.repository.UserRepository;

@Service
public class CartAllocationServiceImpl implements CartAllocationService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Cart addToCart(CartDTO cartDTO) throws ZoanException{
//		Optional<Cart> obj = cartRepository.findById(cartDTO.getUserEmail());
//		if(obj.isPresent()) {
//			throw new ZoanException("Service.CART_ITEM_EXISTS");
//		}
		Cart cart = new Cart();
		cart.setItemId(cartDTO.getItemId());
        cart.setName(cartDTO.getName());
        cart.setDescription(cartDTO.getDescription());
        cart.setImage(cartDTO.getImage());
        cart.setUserEmail(cartDTO.getUserEmail());

        cartRepository.save(cart);
        
        return cart;
	}

	@Override
    public List<Cart> getCartItemsByEmail(String userEmail) throws ZoanException{
		return cartRepository.findByUserEmail(userEmail);
    }

	@Override
    public boolean isUserExists(String emailId) throws ZoanException{
		Optional<User> obj = userRepository.findById(emailId);
		if(obj.isEmpty()) {
			return false;
		}
    	return true;
    }

	@Override
	public User addUser(UserDTO userDTO) throws ZoanException{
		Optional<User> obj = userRepository.findById(userDTO.getEmailId());
		if(obj.isPresent()) {
			throw new ZoanException("Service.USER_EXISTS");
		}
		User user = new User();
		user.setCollegeId(userDTO.getCollegeId());
		user.setEmailId(userDTO.getEmailId());
		user.setName(userDTO.getName());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setPassword(userDTO.getPassword());
		
		userRepository.save(user);
		
		return user;
	}
	
	@Override
	public User getUserByEmail(String emailId) throws ZoanException {
	    return userRepository.findById(emailId)
	            .orElseThrow(() -> new ZoanException("Service.USER_NOT_FOUND"));
	}

}
