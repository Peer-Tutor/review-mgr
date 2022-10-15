package com.peertutor.ReviewMgr.service;

import com.peertutor.ReviewMgr.dto.ReviewDTO;
import com.peertutor.ReviewMgr.mapper.ReviewMapper;
import com.peertutor.ReviewMgr.model.Review;
import com.peertutor.ReviewMgr.model.viewmodel.request.ReviewReq;
import com.peertutor.ReviewMgr.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReviewService {
	private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
	
	private final ReviewMapper reviewMapper;
	
	private ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
		this.reviewRepository = reviewRepository;
		this.reviewMapper = reviewMapper;
	}

	public ReviewDTO addReview(ReviewReq req) {
		Review reviewMgr = reviewRepository.findBytutionOrderID(req.tutionOrderID);
		if(reviewMgr == null) {
			reviewMgr = new Review();
		}

		reviewMgr.setTutorID(req.id);
		reviewMgr.settutionOrderID(req.tutionOrderID);
		reviewMgr.setRating(req.rating);
		reviewMgr.setComment(req.comment);

		try {
			reviewMgr = reviewRepository.save(reviewMgr);
		} catch (Exception e) {
			logger.error("Add Review fail: " + e.getMessage());
			return null;
		}

		ReviewDTO result= reviewMapper.toDto(reviewMgr);

		return result;
	}
	public ReviewDTO updateReview(ReviewDTO reviewDTO) {
		Review reviewMgr = reviewRepository.findBytutionOrderID(reviewDTO.getTutionOrderID());
		if(reviewMgr == null) {
			reviewMgr = new Review();
		}

		reviewMgr.setRating(reviewDTO.getRating());
		reviewMgr.setComment(reviewDTO.getComment());

		try {
			reviewMgr = reviewRepository.save(reviewMgr);
		} catch (Exception e) {
			logger.error("Add Review fail: " + e.getMessage());
			return null;
		}

		ReviewDTO result= reviewMapper.toDto(reviewMgr);

		return result;
	}
	public ReviewDTO getAllReview(Long tutorID) {
		Review review = reviewRepository.findByReviewTutorId(tutorID);

		if(review == null) {
			return null;
		}
		ReviewDTO result= reviewMapper.toDto(review);

		return result;
	}



}
