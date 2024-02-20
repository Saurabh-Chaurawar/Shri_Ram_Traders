package com.shriram.service;

import java.util.List;

import com.shriram.entities.Rating;
import com.shriram.entities.User;
import com.shriram.exception.ProductException;
import com.shriram.request.RatingRequest;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
