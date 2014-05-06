package org.tstraszewski.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tstraszewski.model.FlyHistoryEntity;
import org.tstraszewski.model.UserEntity;
import org.tstraszewski.service.FlyHistoryService;
import org.tstraszewski.service.UserService;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	static Logger logger = Logger
			.getLogger("org.tstraszewski.controller.UserControllerImpl");
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlyHistoryService flyHistoryService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addUser(@RequestBody final UserEntity user) {
		if(logger.isDebugEnabled()){
			logger.debug("wywolanie addUser");
			logger.debug("Otrzymalem: " + user);
		}
		
		userService.add(user);
		
		
		
		if(logger.isDebugEnabled()){
			List<UserEntity> l = userService.getAll();
			for (UserEntity userEntity : l) {
				logger.debug(l);
			}
			List<FlyHistoryEntity> ll = flyHistoryService.getAll();
			for(FlyHistoryEntity fh : ll){
				logger.debug(fh);
			}
		}
	}

	public void deleteUser(UserEntity u) {
	}

	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
