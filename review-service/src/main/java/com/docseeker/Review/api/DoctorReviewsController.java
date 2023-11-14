package com.docseeker.Review.api;

import com.docseeker.Review.domain.service.ReviewService;
import com.docseeker.Review.mapping.ReviewMapper;
import com.docseeker.Review.resource.ReviewResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/reviews")
public class DoctorReviewsController {
    private final ReviewService reviewService;
    private final ReviewMapper mapper;

    public DoctorReviewsController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    /*@GetMapping
    public List<ReviewResource> getAllReviewsByAssociatedDoctor(@PathVariable int id){
        return mapper.toResourceList(reviewService.findAllByAssociatedDoctor(id));
    }*/
}
