package com.shriram.service;

import java.util.List;

import com.shriram.entities.Review;
import com.shriram.entities.User;
import com.shriram.exception.ProductException;
import com.shriram.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
