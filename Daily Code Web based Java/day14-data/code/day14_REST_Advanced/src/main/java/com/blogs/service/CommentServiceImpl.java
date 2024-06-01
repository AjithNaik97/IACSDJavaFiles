package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.controller.CommenterController;
import com.blogs.custom_exceptions.ApiException;
import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.BlogPostDTO;
import com.blogs.dto.CommentDTO;
import com.blogs.entities.BlogPost;
import com.blogs.entities.Category;
import com.blogs.entities.Comment;
import com.blogs.entities.User;
import com.blogs.repository.BlogPostRepository;
import com.blogs.repository.CategoryRepository;
import com.blogs.repository.CommentRepository;
import com.blogs.repository.UserRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	// depcy
	@Autowired
	private BlogPostRepository blogPostRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addComment(CommentDTO dto) {
		//get commenter
		User commenter=userRepository.findById(dto.getCommenterId())
				.orElseThrow(()->new ResourceNotFoundException("Invalid commenter id!!!"));
		//get post
		BlogPost post=blogPostRepository.findById(dto.getPostId())
				.orElseThrow(()->new ResourceNotFoundException("Invalid post id!!!"));
		//validate - same blogger can't add the cmment on the same
		if(commenter.getId()==post.getAuthor().getId())
			throw new ApiException("Bloggers can't comment on their own post");
		//map dto --> entity
		Comment comment = mapper.map(dto, Comment.class);
		//establish E-R
		//comment --> user
		comment.setCommenter(commenter);
		//comment-->post
		comment.setPost(post);
		//since there is no cascading, you will have to explicitly save
		Comment saveComment=commentRepository.save(comment);
		
		return new ApiResponse("new comment to post added ");
	}
	/*
	 * In case of success --hibernate , as a def. implementor will commit tx n then closes the session)
	 */

}
