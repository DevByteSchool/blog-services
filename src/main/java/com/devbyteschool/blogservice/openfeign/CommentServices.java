package com.devbyteschool.blogservice.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("comment-service")
public interface CommentServices {

    @GetMapping("v1/comments/{blogId}")
    public ResponseEntity<String> getBlogCall(@PathVariable String blogId);

}

