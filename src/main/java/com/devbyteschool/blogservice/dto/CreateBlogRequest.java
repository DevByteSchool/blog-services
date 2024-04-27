package com.devbyteschool.blogservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateBlogRequest {


    private String title;

    private String description;

    private Boolean publish;

    private String userId;

}
