package com.docseeker.Review.testing.service;

import com.docseeker.Review.domain.model.entity.Review;
import com.docseeker.Review.domain.persistence.ReviewRepository;
import com.docseeker.Review.service.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReviewServiceTest {
  @InjectMocks
  private ReviewServiceImpl reviewService;

  @Mock
  private ReviewRepository reviewRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testFetchAll() {
    List<Review> reviews = new ArrayList<>();
    reviews.add(new Review(1, "Review 1",5,1,1));
    reviews.add(new Review(2, "Review 2",3,2,2));

    when(reviewRepository.findAll()).thenReturn(reviews);

    List<Review> fetchedReviews = reviewService.fetchAll();
    assertEquals(reviews.size(), fetchedReviews.size());
    assertEquals(reviews, fetchedReviews);
  }

  @Test
  public void testFetchById() {
    Review review = new Review(1, "Review 1",5,1,1);

    when(reviewRepository.findById(1)).thenReturn(Optional.of(review));

    Optional<Review> fetchedReview = reviewService.fetchById(1);
    assertTrue(fetchedReview.isPresent());
    assertEquals(review, fetchedReview.get());
  }

  @Test
  public void testSave() {
    Review review = new Review(1, "Review 1",5,1,1);

    when(reviewRepository.save(review)).thenReturn(review);

    Review savedReview = reviewService.save(review);
    assertEquals(review, savedReview);
  }

  @Test
  public void testUpdate() {
    Review review = new Review(1, "Review 1",5,1,1);

    when(reviewRepository.save(review)).thenReturn(review);

    Review updatedReview = reviewService.update(review);
    assertEquals(review, updatedReview);
  }

  @Test
  public void testDeleteById() {
    when(reviewRepository.existsById(1)).thenReturn(true);

    boolean result = reviewService.deleteById(1);
    assertTrue(result);
  }

  @Test
  public void testDeleteById_ReviewNotFound() {
    when(reviewRepository.existsById(2)).thenReturn(false);

    boolean result = reviewService.deleteById(2);
    assertFalse(result);
  }

  @Test
  public void testFindAllByAssociatedDoctor() {
    List<Review> reviews = new ArrayList<>();
    reviews.add(new Review(1, "Review 1",5,1,1));
    reviews.add(new Review(2, "Review 2",5,1,1));

    when(reviewRepository.findAllByAssociatedDoctor(1)).thenReturn(reviews);

    List<Review> result = reviewService.findAllByAssociatedDoctor(1);
    assertEquals(2, result.size());
    assertEquals("Review 1", result.get(0).getDescription());
    assertEquals("Review 2", result.get(1).getDescription());

    verify(reviewRepository, times(1)).findAllByAssociatedDoctor(1);
  }
}
