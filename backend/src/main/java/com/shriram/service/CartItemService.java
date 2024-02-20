package com.shriram.service;

import com.shriram.entities.Cart;
import com.shriram.entities.CartItem;
import com.shriram.entities.Product;
import com.shriram.exception.CartItemException;
import com.shriram.exception.UserException;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size, Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
