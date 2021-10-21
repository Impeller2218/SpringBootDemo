package org.impelsys.SpringBootDemo.service;

import java.util.List;

import org.impelsys.SpringBootDemo.dao.CommentDaoImpl;
import org.impelsys.SpringBootDemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	CommentDaoImpl commentDao;
	
	public List<Message> getAllComments(){
		
		return commentDao.listComments();
	}

	public Message getComment(int id) {
		// TODO Auto-generated method stub
		
		return commentDao.getComment(id);
	}
}
