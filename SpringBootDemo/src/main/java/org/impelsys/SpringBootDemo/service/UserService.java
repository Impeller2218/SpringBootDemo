package org.impelsys.SpringBootDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.impelsys.SpringBootDemo.dao.UserLoginRepository;
import org.impelsys.SpringBootDemo.model.User;
import org.impelsys.SpringBootDemo.model.userLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserLoginRepository userRepository;
	
	public List<userLogin> getAllUSers(){
		List<userLogin> userList = new ArrayList();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}
	
	public User getUser(int id) throws UserNotFoundException{
		User  user = userRepository.findById(id)
				.orElseThrow(()->new UserNotFoudException(id));
		return user;
	}
}
