package com.docseeker.Review.api;

import com.docseeker.Review.domain.model.entity.Review;
import com.docseeker.Review.domain.service.ReviewService;
import com.docseeker.Review.mapping.ReviewMapper;
import com.docseeker.Review.resource.CreateReviewResource;
import com.docseeker.Review.resource.ReviewResource;
import com.docseeker.Review.resource.UpdateReviewResource;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@AllArgsConstructor
@CrossOrigin
public class ReviewController {
  private final ReviewService reviewService;
  private final ReviewMapper mapper;

  @Operation(summary = "Get all")
  @GetMapping
  public List<Review> fetchAll() {
    return reviewService.fetchAll();
  }

  @PostMapping
  public ReviewResource save(@RequestBody CreateReviewResource resource) {
    return mapper.toResource(reviewService.save(mapper.toModel(resource)));
  }

  @GetMapping("{id}")
  public ReviewResource fetchId(@PathVariable Integer id) {
    //return studentService.fetchById(id).get();
    return this.mapper.toResource(reviewService.fetchById(id).get());
  }

  @PutMapping("{id}")
  public ResponseEntity<ReviewResource> update(@PathVariable Integer id,
                                               @RequestBody UpdateReviewResource resource){
    if (id.equals(resource.getId())) {
      ReviewResource reviewResource = mapper.toResource(
        reviewService.update( mapper.toModel(resource) ) );
      return new ResponseEntity<>(reviewResource, HttpStatus.OK);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @Operation(summary = "Delete by Id")
  @DeleteMapping("{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    if(reviewService.deleteById(id)){
      return ResponseEntity.ok().build(); //Devolver de forma directa - lambda
      //return new ResponseEntity<>(HttpStatus.OK); //Devoluicon con instanciación
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(summary = "Get reviews by associated doctor")
    @GetMapping("/doctor/{id}")
    public List<Review> getAllReviewsByAssociatedDoctor(@PathVariable int id){
      return reviewService.findAllByAssociatedDoctor(id);
  }
}
