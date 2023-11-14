package com.docseeker.Review.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 1000)
  private String description;
  private Integer rating;

  /*@ManyToOne
  @JoinColumn(name = "doctor_id")
  @JsonBackReference*/
  private Integer associatedDoctor;

  /*@ManyToOne
  @JoinColumn(name = "patient_id")
  @JsonBackReference*/
  private Integer createdBy;
}
