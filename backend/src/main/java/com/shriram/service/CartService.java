package com.shriram.service;

import com.shriram.entities.Cart;
import com.shriram.entities.CartItem;
import com.shriram.entities.User;
import com.shriram.exception.ProductException;
import com.shriram.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public CartItem addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
