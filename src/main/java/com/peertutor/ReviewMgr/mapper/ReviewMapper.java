package com.peertutor.ReviewMgr.mapper;

import com.peertutor.ReviewMgr.dto.ReviewDTO;
import com.peertutor.ReviewMgr.model.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends EntityMapper<ReviewDTO,Review>{
	Review toEntity(ReviewDTO reviewDTO);

	ReviewDTO toDto(Review review);

    default Review fromId(Long id) {
        if (id == null) {
            return null;
        }
        Review review = new Review();
        review.setId(id);
        return review;
    }
}

