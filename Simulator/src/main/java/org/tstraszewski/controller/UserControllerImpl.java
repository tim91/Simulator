package org.tstraszewski.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tstraszewski.model.UserEntity;
import org.tstraszewski.service.UserService;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	static Logger logger = Logger
			.getLogger("org.tstraszewski.controller.UserControllerImpl");
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addUser(@RequestBody final UserEntity user) {
		if(logger.isDebugEnabled()){
			logger.debug("wywolanie addUser");
			logger.debug("Otrzymalem: " + user);
		}
		
		userService.add(user);
		
	}

	public void deleteUser(UserEntity u) {
	}

	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	
	public @ResponseBody List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userService.getAll();
	}

	@RequestMapping(value="/getId", method = RequestMethod.GET)
	public @ResponseBody int getUserId() {
		
		UserEntity ue  = userService.getByName("tim91");
		return ue.getId();
		
	}
	
	
}
