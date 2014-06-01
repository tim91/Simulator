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
import org.tstraszewski.model.FlyHistoryEntity;
import org.tstraszewski.model.UserEntity;
import org.tstraszewski.service.FlyHistoryService;
import org.tstraszewski.service.UserService;

@Controller
@RequestMapping("/flyHistory")
public class FlyHistoryControllerImpl implements FlyHistoryController {

	static Logger logger = Logger
			.getLogger("org.tstraszewski.controller.FlyHistoryControllerImpl");
	
	@Autowired
	FlyHistoryService flyHistoryService;
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public void addHistory(@RequestBody final FlyHistoryEntity fhe) {
		
		System.out.println("Dodaje historie: " + fhe);
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    String name = auth.getName();
//		
	    UserEntity us = userService.getByName("tim91");
	    
	    fhe.setUser(us);
	    
	    
		if(logger.isDebugEnabled()){
			logger.debug(fhe);
		}
		
		flyHistoryService.add(fhe);
	}

	public void deleteHistory(FlyHistoryEntity fhe) {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public @ResponseBody List<FlyHistoryEntity> getAll() {
		// TODO Auto-generated method stub
		List<FlyHistoryEntity> entities = flyHistoryService.getAll();
		
		return entities;
	}
	
	@RequestMapping(value="/byUserId")
	public @ResponseBody List<Integer> getHistory(@RequestParam("userId") int userId){
		
		System.out.println("Userid: " + userId);
		List<Integer> li = flyHistoryService.getByUserId(userId);
		return li;
	}
	
}
