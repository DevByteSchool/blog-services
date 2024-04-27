package com.devbyteschool.blogservice.repository;

import com.devbyteschool.blogservice.model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

    Blog deleteByBlogId(String blogId);

    List<Blog> findByUserId(String blogId, Pageable pageable);

    Blog findByBlogId(String blogId);


}
