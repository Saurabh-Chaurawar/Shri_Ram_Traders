package com.shriram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shriram.entities.Cart;
import com.shriram.entities.CartItem;
import com.shriram.entities.Product;
import com.shriram.entities.User;
import com.shriram.exception.ProductException;
import com.shriram.repository.CartRepository;
import com.shriram.request.AddItemRequest;

@Service
@Transactional
public class CartServiceImplementation implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private ProductService productService;

	@Override
	public Cart createCart(User user) {
		
		Cart cart = new Cart();
		cart.setUser(user);
		Cart createdCart=cartRepository.save(cart);
		return createdCart;
	}
	
	public Cart findUserCart(Long userId) {
		Cart cart =	cartRepository.findByUserId(userId);
		int totalPrice=0;
		int totalDiscountedPrice=0;
		int totalItem=0;
		for(CartItem cartsItem : cart.getCartItems()) {
			totalPrice+=cartsItem.getPrice();
			totalDiscountedPrice+=cartsItem.getDiscountedPrice();
			totalItem+=cartsItem.getQuantity();
		}
		
		cart.setTotalPrice(totalPrice);
		cart.setTotalItem(cart.getCartItems().size());
		cart.setTotalDiscountedPrice(totalDiscountedPrice);
		cart.setDiscounte(totalPrice-totalDiscountedPrice);
		cart.setTotalItem(totalItem);
		
		return cartRepository.save(cart);
		
	}

	@Override
	public CartItem addCartItem(Long userId, AddItemRequest req) throws ProductException {
		Cart cart=cartRepository.findByUserId(userId);
		Product product=productService.findProductById(req.getProductId());
		
		CartItem isPresent=cartItemService.isCartItemExist(cart, product, req.getSize(),userId);
		
		if(isPresent == null) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(req.getQuantity());
			cartItem.setUserId(userId);
			
			
			int price=req.getQuantity()*product.getDiscountedPrice();
			cartItem.setPrice(price);
			cartItem.setSize(req.getSize());
			
			CartItem createdCartItem=cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createdCartItem);
			return createdCartItem;
		}
		
		
		return isPresent;
	}

}
