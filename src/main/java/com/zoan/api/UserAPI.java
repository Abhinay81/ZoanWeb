package com.zoan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoan.dto.CartDTO;
import com.zoan.dto.UserDTO;
import com.zoan.entity.Cart;
import com.zoan.entity.User;
import com.zoan.exception.ZoanException;
import com.zoan.service.CartAllocationService;

@RestController
@RequestMapping(value="/zoan")
@CrossOrigin(origins = "*")
public class UserAPI {
	
	@Autowired
	private CartAllocationService cartAllocationService;
	
	@PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserDTO userDTO) throws ZoanException {
        boolean flag = cartAllocationService.isUserExists(userDTO.getEmailId());
        return new ResponseEntity<>(flag,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) throws ZoanException {
        User user = cartAllocationService.addUser(userDTO);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @PostMapping("/cart/add")
    public ResponseEntity<Cart> addItemToCart(@RequestBody CartDTO cartDTO) throws ZoanException {
        Cart cart = cartAllocationService.addToCart(cartDTO);
        return new ResponseEntity<>(cart,HttpStatus.CREATED);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) throws ZoanException {
        if (!cartAllocationService.isUserExists(email)) {
            throw new ZoanException("Service.USER_NOT_FOUND");
        }
        User user = cartAllocationService.getUserByEmail(email); // implement this method
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/cart/{email}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable String email) throws ZoanException {
        List<Cart> cart = cartAllocationService.getCartItemsByEmail(email);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
}
