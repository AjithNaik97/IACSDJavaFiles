package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.BlogPost;
import com.app.entities.Comment;
import com.app.entities.User;

public class CommenterDaoImpl implements CommenterDao {

	@Override
	public String addNewComment(Comment newComment, Long commenter_id, Long post_id) {
		String mesg = "Adding comment failed";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			User user=session.get(User.class, commenter_id);
			//4. Get post from the id
			BlogPost post=session.get(BlogPost.class, post_id);
			if(user!=null&&post!=null&&commenter_id!=post.getAuthor().getId())
			{
				//user and post - persistent
				//establish uni directional association comment
				newComment.setCommenter(user);
				//comment -->post
				newComment.setPost(post);
				//save the comment
				session.persist(newComment);
				mesg="commented on the post";
			}		
			tx.commit();			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

//	@Override
//	public String deleteCategoryDetails(Long categoryId) {
//		String mesg = "deleting category failed";
//		// String jpql="delete from Category c where c.id=:id";
//		// 1. get session from SF (getCurrentSession)
//		Session session = getFactory().getCurrentSession();
//		// 2. Begin a Tx
//		Transaction tx = session.beginTransaction();
//		try {
////			int rows=session.createQuery(jpql)
////					.setParameter("id", categoryId)
////					.executeUpdate();
////			System.out.println("rows deleted "+rows);
//			// get category from id
//			Category category = session.get(Category.class, categoryId);
//			if (category != null) {
//				// => category - persistent
//				session.delete(category);
//				mesg="deleted category along with child recs";
//			}
//			tx.commit();// session.flush --> dirty checking --> casacding --> child recs n then parent
//						// rec will be deleted
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			// re throw the exc to the caller
//			throw e;
//		}
//		return mesg;
//	}
//
//	@Override
//	public Category getCategoryDetails(String categoryName) {
//		Category category = null;
//		String jpql="select c from Category c where c.name=:nm";
//		// 1. get session from SF (getCurrentSession)
//		Session session = getFactory().getCurrentSession();
//		// 2. Begin a Tx
//		Transaction tx = session.beginTransaction();
//		try {
//			category=session.createQuery(jpql,Category.class)
//					.setParameter("nm", categoryName)
//					.getSingleResult();
//			//category : persistent
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			// re throw the exc to the caller
//			throw e;
//		}
//		return category;//detached
//	}
//
//	@Override
//	public Category getCategoryAndPostDetails(String categoryName) {
//		Category category = null;
//		String jpql="select c from Category c left join fetch c.posts  where c.name=:nm";
//		// 1. get session from SF (getCurrentSession)
//		Session session = getFactory().getCurrentSession();
//		// 2. Begin a Tx
//		Transaction tx = session.beginTransaction();
//		try {
//			category=session.createQuery(jpql,Category.class)
//					.setParameter("nm", categoryName)
//					.getSingleResult();
//			//category : persistent 
//			//access the collection of posts
//		//	category.getPosts().size();
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			// re throw the exc to the caller
//			throw e;
//		}
//		return category;//detached
//	
//	}

}
