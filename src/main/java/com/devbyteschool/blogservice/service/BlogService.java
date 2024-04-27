package com.devbyteschool.blogservice.service;

import com.devbyteschool.blogservice.dto.CommonPaginationRequest;
import com.devbyteschool.blogservice.dto.CreateBlogRequest;
import com.devbyteschool.blogservice.dto.UpdateBlogRequest;
import com.devbyteschool.blogservice.model.Blog;
import com.devbyteschool.blogservice.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;


    public Blog createBlog(CreateBlogRequest createBlogRequest) throws Exception {
        Blog blog = new Blog();
        BeanUtils.copyProperties(createBlogRequest, blog);
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public Blog updateBlog(UpdateBlogRequest updateBlogRequest) throws Exception {
        Blog blog = blogRepository.findByBlogId(updateBlogRequest.getBlogId());
        if (ObjectUtils.isEmpty(blog)) return null;
        BeanUtils.copyProperties(updateBlogRequest, blog);
        blog.setUpdatedAt(LocalDateTime.now());
        log.info("BlogService:updateBlog record updated successfully with blogId  : {}", blog.getBlogId());
        return blogRepository.save(blog);
    }

    public void deleteBlog(String blogId) throws Exception {
        blogRepository.deleteByBlogId(blogId);
    }

    public Blog getBlog(String blogId) throws Exception {
        return blogRepository.findByBlogId(blogId);
    }

    public List<Blog> getBlogs(CommonPaginationRequest commonPaginationRequest) throws Exception {
        Pageable pageable = PageRequest.of(commonPaginationRequest.getPageNo(), commonPaginationRequest.getPageSize(),
                Sort.by(commonPaginationRequest.getSortBy()).descending());
        return blogRepository.findByUserId(commonPaginationRequest.getValue(), pageable);
    }

}
