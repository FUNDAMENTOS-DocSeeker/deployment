package com.docseeker.Review.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewResource {
  private Integer id;
  private String description;
  private Integer rating;
  private Integer associatedDoctor;
  private Integer createdBy;

  public Integer getId() {
    return id;
  }
}
