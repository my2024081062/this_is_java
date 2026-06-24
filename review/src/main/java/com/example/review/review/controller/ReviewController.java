package com.example.review.review.controller;

import com.example.review.review.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewPhotoRepository reviewPhotoRepository;
    private final ReviewReactionRepository reviewReactionRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewCategoryRepository reviewCategoryRepository;
    private final ReviewCategoryMasterRepository reviewCategoryMasterRepository;
    private final ReviewTagRepository reviewTagRepository;
    private final ReviewTagMasterRepository reviewTagMasterRepository;


    
}
