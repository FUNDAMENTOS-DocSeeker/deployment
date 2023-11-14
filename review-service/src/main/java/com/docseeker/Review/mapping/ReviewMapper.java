package com.docseeker.Review.mapping;

import com.docseeker.Review.domain.model.entity.Review;
import com.docseeker.Review.resource.CreateReviewResource;
import com.docseeker.Review.resource.ReviewResource;
import com.docseeker.Review.resource.UpdateReviewResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ReviewMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public Review toModel(CreateReviewResource resource) {
    return this.mapper.map(resource, Review.class);
  }
  public Review toModel(UpdateReviewResource resource) {
    return this.mapper.map(resource, Review.class);
  }
  public ReviewResource toResource(Review model) {
    return this.mapper.map(model, ReviewResource.class);
  }
  public List<ReviewResource> toResourceList(List<Review> modelList) {
    return this.mapper.mapList(modelList, ReviewResource.class);
  }
}
