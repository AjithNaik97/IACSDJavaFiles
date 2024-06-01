package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostDTO;
import com.blogs.dto.CommentDTO;
import com.blogs.service.BlogPostService;
import com.blogs.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommenterController {
//depcy 
	@Autowired
	private CommentService commentService;
	/*
	 * For adding a new comment.
i/p - title , desc , contents , category id ,  author id 
     URL - http://host:port/posts ,
     Method - POST
     payload - blog post dto 
     resp - DTO (api resp : mesg)
	 */
	@PostMapping
	public ApiResponse addNewComment(@RequestBody CommentDTO comDTO)
	{
		System.out.println("in add post "+comDTO);
		return commentService.addComment(comDTO);
	}
}
