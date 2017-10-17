package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	public User getUser(Integer id) {
		return userRepository.findOne(id);
	}
	public void addUser(User user) {
		userRepository.save(user);
	}
	public void updateUser(Integer id, User user) {
		userRepository.save(user);
	}
	public void deleteUser(Integer id) {
		userRepository.delete(id);
	}
	
}
