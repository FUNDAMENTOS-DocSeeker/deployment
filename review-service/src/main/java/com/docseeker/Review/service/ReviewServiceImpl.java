package com.docseeker.Review.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.docseeker.Review.domain.model.entity.Review;
import com.docseeker.Review.domain.persistence.ReviewRepository;
import com.docseeker.Review.domain.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Override
  public List<Review> fetchAll() {
    return reviewRepository.findAll();
  }

  @Override
  public Optional<Review> fetchById(Integer id) {
    return reviewRepository.findById(id);
  }

  @Override
  public List<Review> findAllByAssociatedDoctor(int associatedDoctor) {
    return reviewRepository.findAllByAssociatedDoctor(associatedDoctor);
  }

  @Override
  public Review save(Review appointment) {
    return reviewRepository.save(appointment);
  }

  @Override
  public Review update(Review appointment) {
    return reviewRepository.save(appointment);
  }

  @Override
  public boolean deleteById(Integer id) {
    if (reviewRepository.existsById(id)) {
      reviewRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
