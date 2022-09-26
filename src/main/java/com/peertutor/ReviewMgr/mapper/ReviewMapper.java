package com.peertutor.ReviewMgr.mapper;

import com.peertutor.ReviewMgr.dto.ReviewDTO;
import com.peertutor.ReviewMgr.model.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends EntityMapper<ReviewDTO,Review>{

}

