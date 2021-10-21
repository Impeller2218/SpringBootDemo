package org.impelsys.SpringBootDemo.service;

import org.impelsys.SpringBootDemo.dao.UserLoginRepository;
import org.impelsys.SpringBootDemo.model.UserPrincipal;
import org.impelsys.SpringBootDemo.model.userLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserLoginService implements UserDetailsService {
	@Autowired
	private UserLoginRepository userLoginRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//get username from repository
		userLogin user=userLoginRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("Non Existent User");
		
		return new UserPrincipal(user);
	}
}