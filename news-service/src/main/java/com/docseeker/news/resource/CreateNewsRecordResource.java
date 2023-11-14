package com.docseeker.news.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewsRecordResource {
    private String title;
    private String description;
    private String imageUrl;
}
