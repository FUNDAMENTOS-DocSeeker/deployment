package com.docseeker.news.domain.persistance;

import com.docseeker.news.domain.model.entity.NewsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRecordRepository extends JpaRepository<NewsRecord, Integer> {
}
