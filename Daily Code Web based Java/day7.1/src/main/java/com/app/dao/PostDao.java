package com.app.dao;

import java.util.List;

import com.app.entities.Post;

public interface PostDao {
	//add a method to upload post
	String UploadPost(Post post);
	
	//add a method to display all post
	List<Post> getAllPost();
	
	//add a method to display post by title
	Post getPostByTitle(String title);
	

}