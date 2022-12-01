package tn.showroom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.showroom.Repository.UserRepository;
import tn.showroom.entity.User;


@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		return userRepository.save(user);
	}

}