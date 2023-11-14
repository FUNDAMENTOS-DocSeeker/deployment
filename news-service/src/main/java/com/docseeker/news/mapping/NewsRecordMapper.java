package com.docseeker.news.mapping;

import com.docseeker.news.domain.model.entity.NewsRecord;
import com.docseeker.news.resource.CreateNewsRecordResource;
import com.docseeker.news.resource.NewsRecordResource;
import com.docseeker.news.resource.UpdateNewsRecordResource;
import com.docseeker.news.shared.EnhacedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class NewsRecordMapper implements Serializable {

    @Autowired
    EnhacedModelMapper mapper;

    // from model to entity
    public NewsRecord toModel(CreateNewsRecordResource resource) {
        return this.mapper.map(resource, NewsRecord.class);
    }

    // from model to entity
    public NewsRecord toModel(UpdateNewsRecordResource resource) {
        return this.mapper.map(resource, NewsRecord.class);
    }

    // from model to entity
    public NewsRecordResource toResource(NewsRecord newsRecord) {
        return this.mapper.map(newsRecord, NewsRecordResource.class);
    }
}
