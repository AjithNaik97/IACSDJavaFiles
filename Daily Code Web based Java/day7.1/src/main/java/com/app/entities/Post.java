package com.app.entities;
import javax.persistence.*;

//column - id , content , description, title 
@Entity // class level , run time anno for hibernate to manage the entities(i.e life
		// cycle) : mandatory
@Table(name="posts") //for specifying table name 
public class Post {
// ID property in hibernate managed entities MUST be Serializable
// till Hibernate 5.
@Id //mandatory => PK constraint
//for automatic id generation by hibernate(JPA)
//strategy = GenerationType.IDENTITY => 
//most suitable for MySql => auto increment
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=255,name="content")//content:varchar(255)
	private String content;
	@Column (length=255,name="description")//description:varchar(255)
	private String description;
	@Column(length = 100,name="title")//title:description(100)
	private String title;
	
	//def Constructor
	public Post() {
	}
	
	//parameterized constructor
	public Post(String content,String description,String title)
	{
	super();
	this.content=content;
	this.description=description;
	this.title=title;
	}

//getter nd setters
	public Long getPost_id() {
		return getPost_id();
	}

	public void setPost_id(Long post_id) {
		this.id = post_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + id + ", content=" + content + ", description=" + description + ", title=" + title
				+ "]";
	}


}