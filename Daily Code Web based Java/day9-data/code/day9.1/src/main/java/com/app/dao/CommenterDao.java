package com.app.dao;

import com.app.entities.Category;
import com.app.entities.Comment;

public interface CommenterDao {

	

	String addNewComment(Comment comment, Long user_id, Long post_id);
	
}
