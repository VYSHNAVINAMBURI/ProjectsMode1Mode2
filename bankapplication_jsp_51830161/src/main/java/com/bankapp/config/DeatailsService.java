package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;

@Service
public class DeatailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=null;
		user=userService.findByEmail(email);
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}else {
			//user=user.get(0);
		
		return new org.springframework.security.core.userdetails.User
				(user.getEmail(),user.getPassword(),
						AuthorityUtils.createAuthorityList(user.getRoles()));
		}
	}

}
