package org.impelsys.SpringBootDemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userDao")
@Transactional//
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int addUser(User user) {
//		Long startTime=System.currentTimeMillis();
//		System.out.println();
		// TODO Auto-generated method stub
		int row;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		row = (int)session.save(user);
		System.out.println("created with id " + row);
		tx.commit();
		session.close();
		return row;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setId(id);
		session.delete(user);
		tx.commit();
		session.close();
	}

	@Override
	public User viewUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		User user = session.get(User.class,new Integer(id));
		session.close();
		System.out.println(user);
		return user;
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List <User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}


}
