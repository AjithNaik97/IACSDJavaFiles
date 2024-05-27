package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.PostDao;
import com.app.dao.PostDaoImpl;
import com.app.entities.Post;

public class UploadPost {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create post dao instance
			PostDao postDao = new PostDaoImpl();
			System.out.println("Enter Post details - Content, Description, Title");
			Post transientPost = new Post(sc.next(), sc.next(), sc.next());
			System.out.printf(postDao.UploadPost(transientPost));
		} // JVM sf.close() => cleaning up of DBCP
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}