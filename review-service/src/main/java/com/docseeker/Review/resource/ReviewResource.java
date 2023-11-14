package com.docseeker.Review.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResource {
  private Integer id;
  private String description;
  private Integer rating;
  private Integer associatedDoctor;
  private Integer createdBy;
}
