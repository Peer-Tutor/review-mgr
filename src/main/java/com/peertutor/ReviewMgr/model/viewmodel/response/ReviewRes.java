package com.peertutor.ReviewMgr.model.viewmodel.response;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.peertutor.ReviewMgr.dto.ReviewDTO;

public class ReviewRes {

	public Long id;

	public Long tutorID;

	public Long tutionOrderID;

	public int rating;

	public String comment;
    
	 public ReviewRes(ReviewDTO reviewDTO) {
		 	this.id = reviewDTO.getId();
		 	this.tutorID = reviewDTO.getTutorID();
		 	this.tutionOrderID = reviewDTO.getTutionOrderID();
		 	this.rating = reviewDTO.getRating();
		 	this.comment =reviewDTO.getComment();
	    }

}
