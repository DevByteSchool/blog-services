package com.devbyteschool.blogservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetBlogResponse {

    private String title;

    private String description;

    private Boolean publish;

    private String userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<Comment> comments;


}
