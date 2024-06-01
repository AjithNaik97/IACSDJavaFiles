package com.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blogs.dto.BlogPostDetails;
import com.blogs.entities.BlogPost;
import com.blogs.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
