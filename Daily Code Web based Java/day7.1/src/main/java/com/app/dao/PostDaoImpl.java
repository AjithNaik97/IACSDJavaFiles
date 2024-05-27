package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.app.entities.Post;

public class PostDaoImpl implements PostDao {

	@Override
	public String UploadPost(Post post) {
		
		//1. GetSession from sessionFactory(get current session)
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			Serializable post_id = session.save(post);
			System.out.println("Id class"+post_id.getClass());
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
				//re throw the exception of the caller
			throw e;
			}
		}
		return "Post Uploaded Successfully...";

	}
	
	
	public List<Post> getAllPost(){
		List<Post> posts=null;
		String jpql="select p from Post p";
		//1. GetSession from sessionFactory(get current session)
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			posts=session.createQuery(jpql,Post.class)
					.getResultList();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
				//re throw the exception of the caller
			throw e;
			}
		}
		return posts;
		
	}


	@Override
	public Post getPostByTitle(String title) {
		Post post =null;
		String jpql="select p from Post p where p.title=:title";
		//1. GetSession from sessionFactory(get current session)
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			post=session.createQuery(jpql,Post.class)
					.setParameter("title", title)
					.getSingleResult();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
				//re throw the exception of the caller
			throw e;
			}
		}
		return post;
		
	}

}