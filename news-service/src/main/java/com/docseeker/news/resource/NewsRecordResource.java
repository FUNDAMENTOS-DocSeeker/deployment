package com.docseeker.news.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class NewsRecordResource {
    private Integer id;
    private String title;
    private String description;
    private String imageUrl;
}
