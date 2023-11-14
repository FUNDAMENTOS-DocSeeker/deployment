package com.docseeker.Review.domain.service;

import com.docseeker.Review.domain.model.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
  List<Review> fetchAll();
  Optional<Review> fetchById(Integer id);
  List<Review> findAllByAssociatedDoctor(int associatedDoctor);
  Review save(Review appointment);
  Review update(Review appointment);
  boolean deleteById(Integer id);

}
