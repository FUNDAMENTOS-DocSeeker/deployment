package com.docseeker.news.api;

import com.docseeker.news.domain.model.entity.NewsRecord;
import com.docseeker.news.domain.service.NewsRecordService;
import com.docseeker.news.mapping.NewsRecordMapper;
import com.docseeker.news.resource.CreateNewsRecordResource;
import com.docseeker.news.resource.NewsRecordResource;
import com.docseeker.news.resource.UpdateNewsRecordResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/v1/news")
public class NewsRecordController {

    private NewsRecordService newsRecordService;
    private NewsRecordMapper mapper;

    public NewsRecordController(NewsRecordService newsRecordService, NewsRecordMapper mapper) {
        this.newsRecordService = newsRecordService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity<List<NewsRecord>> fetchAll() {
        return ResponseEntity.ok(newsRecordService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<NewsRecordResource> fetchId(@PathVariable Integer id) {
        if (newsRecordService.getById(id).isPresent()) {
            NewsRecordResource newsRecordResource = this.mapper.toResource(newsRecordService.getById(id).get());
            return ResponseEntity.ok(newsRecordResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("")
    public NewsRecordResource save(@RequestBody CreateNewsRecordResource resource) {
        return mapper.toResource(newsRecordService.save(mapper.toModel(resource)));
    }

    @PutMapping("{id}")
    public ResponseEntity<NewsRecordResource> update(@PathVariable Integer id, @RequestBody UpdateNewsRecordResource resource){
        if (id.equals(resource.getId())) {
            NewsRecordResource newsRecordResource =
                    mapper.toResource(
                            newsRecordService.update(
                                    mapper.toModel(resource)
                            )
                    );
            return ResponseEntity.ok(newsRecordResource);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (newsRecordService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
