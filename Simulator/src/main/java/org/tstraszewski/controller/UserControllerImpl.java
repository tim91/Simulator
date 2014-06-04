package org.tstraszewski.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		UserEntity ue  = userService.getByName(getCurrentLoggedUserName());
		return ue.getId();
		
	}

	@RequestMapping(value="/get/{id}")
	public @ResponseBody UserEntity getById(@PathVariable int id) {
		
		//TODO sprawdzamy czy user ktorego dostalismy jest aktualnie zalogowanym userem
		UserEntity u = userService.getById(id);
		
		if(u.getNickName().equals(getCurrentLoggedUserName())){
			return u;
		}
		
		return null;
	}

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody UserEntity getCurrentLogged() {
		
		//wyciagam z sesji
		UserEntity ue  = userService.getByName(getCurrentLoggedUserName());
		return ue;
		
	}
	
	private String getCurrentLoggedUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    return name;
	}
	
}
