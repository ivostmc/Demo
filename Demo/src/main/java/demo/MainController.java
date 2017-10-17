package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
		
		@Autowired
		private UserService userService;
		
		@GetMapping(value="/")
		public String homePage() {
			return "index";
		}
		
		@CrossOrigin
		@GetMapping("/users")
		public @ResponseBody List<User> getAllUsers() {
			return userService.getAllUsers();
		}
		@RequestMapping("/users/{id}")
		public @ResponseBody User getTopic(@PathVariable Integer id) {
			return userService.getUser(id);
		}
		@CrossOrigin
		@RequestMapping(method = RequestMethod.POST, value="/users")
		public @ResponseBody void addUser(@RequestBody User user) {
			userService.addUser(user);
		}
		@RequestMapping(method = RequestMethod.PUT, value="/users/{id}")
		public @ResponseBody void updateUser(@RequestBody User user, @PathVariable Integer id) {
			userService.updateUser(id, user);
		}
		@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
		public @ResponseBody void deleteUser(@PathVariable Integer id) {
			userService.deleteUser(id);
		}
	

}
