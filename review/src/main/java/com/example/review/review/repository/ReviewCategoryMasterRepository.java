package com.example.review.review.repository;

import com.example.review.review.entity.ReviewCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCategoryMasterRepository extends JpaRepository<ReviewCategoryMaster, Long> {
}
