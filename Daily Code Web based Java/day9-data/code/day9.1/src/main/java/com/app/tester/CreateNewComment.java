package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.BlogPostDao;
import com.app.dao.BlogPostDaoImpl;
import com.app.dao.CommenterDao;
import com.app.dao.CommenterDaoImpl;
import com.app.entities.BlogPost;
import com.app.entities.Comment;

public class CreateNewComment {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create post dao instance
			CommenterDao dao = new CommenterDaoImpl();
			// for testing - do not add any white space
			System.out.println("Enter comment , rating , user id , post id");
			Comment cmt = new Comment(sc.next(), sc.nextInt());
			System.out.println(dao.addNewComment(cmt, sc.nextLong(), sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
