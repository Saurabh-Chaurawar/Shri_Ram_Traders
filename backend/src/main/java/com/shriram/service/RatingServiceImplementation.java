package com.shriram.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shriram.entities.Product;
import com.shriram.entities.Rating;
import com.shriram.entities.User;
import com.shriram.exception.ProductException;
import com.shriram.repository.RatingRepository;
import com.shriram.request.RatingRequest;

@Service
@Transactional
public class RatingServiceImplementation implements RatingServices{
	
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private ProductService productService;
	

	@Override
	public Rating createRating(RatingRequest req,User user) throws ProductException {
		
		Product product=productService.findProductById(req.getProductId());
		
		Rating rating=new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}
	
	

}
