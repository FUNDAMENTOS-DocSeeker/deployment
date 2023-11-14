package com.docseeker.news.domain.service;

import com.docseeker.news.domain.model.entity.NewsRecord;

import java.util.List;
import java.util.Optional;

public interface NewsRecordService {
    List<NewsRecord> getAll();
    Optional<NewsRecord> getById(Integer id);
    NewsRecord save(NewsRecord newsRecord);
    NewsRecord update(NewsRecord newsRecord);
    boolean deleteById(Integer id);
}
