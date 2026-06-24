package com.example.review.review.repository;

import com.example.review.review.entity.ReviewTagMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewTagRepository extends JpaRepository<ReviewTagMaster, Long> {
}
