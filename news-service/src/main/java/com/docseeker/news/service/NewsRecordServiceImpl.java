package com.docseeker.news.service;

import com.docseeker.news.domain.model.entity.NewsRecord;
import com.docseeker.news.domain.persistance.NewsRecordRepository;
import com.docseeker.news.domain.service.NewsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NewsRecordServiceImpl implements NewsRecordService {

    @Autowired
    private NewsRecordRepository newsRecordRepository;

    @Transactional(readOnly = true)
    @Override
    public List<NewsRecord> getAll() {
        return newsRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<NewsRecord> getById(Integer id) {
        return newsRecordRepository.findById(id);
    }

    @Transactional
    @Override
    public NewsRecord save(NewsRecord newsRecord) {
        return newsRecordRepository.save(newsRecord);
    }

    @Transactional
    @Override
    public NewsRecord update(NewsRecord newsRecord) {
        return newsRecordRepository.save(newsRecord);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (newsRecordRepository.existsById(id)) {
            newsRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
