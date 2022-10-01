package com.peertutor.ReviewMgr.service;

import com.peertutor.ReviewMgr.dto.ReviewDTO;
import com.peertutor.ReviewMgr.mapper.ReviewMapper;
import com.peertutor.ReviewMgr.model.Review;
import com.peertutor.ReviewMgr.model.viewmodel.request.ReviewReq;
import com.peertutor.ReviewMgr.model.viewmodel.request.TuitionOrderReq;
import com.peertutor.ReviewMgr.service.TuitionOrderSvc;
import com.peertutor.ReviewMgr.repository.ReviewRepository;

public abstract class ReviewService implements ReviewRepository {
	private static final Logger logger = LoggerFactory.getLogger(ReviewService .class);
    private final ReviewMapper reviewMapper;
    private ReviewRepository reviewRepository;
    private TuitionOrderSvc tuitionOrderSvc;
    
    public ReviewDTO addReview(ReviewReq req) {
    	Review reviewMgr = reviewRepository.findById(req.id);
    	if(reviewMgr == null) {
    		reviewMgr = new Review();
    	}
    	Long tutionOrdID = tuitionOrderSvc.getTuitionOrderId();
    	Long tutirID = tuitionOrderSvc.getTutorId();

    	reviewMgr.setTutorID(tutirID);
    	reviewMgr.settutionOrderID(tutionOrdID);
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
    public ReviewDTO getAllReview(Long tutionOrderID) {
    	Review review = reviewRepository.findById(tutionOrderID);
    	
    	if(review == null) {
    		return null;
    	}
    	ReviewDTO result= reviewMapper.toDto(review);
    	
        return result;
    }
    
    
    
}
