package org.impelsys.SpringBootDemo.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.impelsys.SpringBootDemo.exception.CommentNotFoundException;
import org.impelsys.SpringBootDemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Repository
public class CommentDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	public List<Message> listComments(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Message",Message.class);
		List<Message> commentsList = query.list();
		session.close();
		return commentsList;
	}
	public Message getComment(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Message message = session.get(Message.class,new Integer(id));
		session.close();
		return message;
	}
	
}
