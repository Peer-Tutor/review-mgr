package com.peertutor.ReviewMgr.repository;

import com.peertutor.ReviewMgr.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByReviewId(long id);
    List<Review> findByReviewTutorId(List<Long> tutorID);
}

