package com.blogs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//title , desc , contents , category id ,  author id
@Getter
@Setter
@ToString
public class CommentDTO extends BaseDTO {
	private String commentText;
	private int rating;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long commenterId;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long postId;
}
