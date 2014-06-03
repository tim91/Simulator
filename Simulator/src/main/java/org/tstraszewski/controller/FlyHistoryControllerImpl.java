package org.tstraszewski.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
	public @ResponseBody int addHistory(@RequestBody final FlyHistoryEntity fhe) {
		
		System.out.println("Dodaje historie: " + fhe);
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    String name = auth.getName();
//		
	    UserEntity us = userService.getByName("tim91");
	    
	    fhe.setUser(us);
	    
	    
		if(logger.isDebugEnabled()){
			logger.debug(fhe);
		}
		
		int id = flyHistoryService.add(fhe);
		
		return id;
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
	
	@RequestMapping(value="/byUserId/{userId}")
	public @ResponseBody List<FlyHistoryEntity> getHistory(@PathVariable int userId){
		
		System.out.println("Userid: " + userId);
		List<FlyHistoryEntity> li = flyHistoryService.getByUserId(userId);
		return li;
	}

	@RequestMapping(value="/byId/{id}")
	public @ResponseBody FlyHistoryEntity getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		FlyHistoryEntity e = flyHistoryService.getById(id);
		return e;
	}
	
	@RequestMapping(value="/byIdAndPlay/{id}")
	public @ResponseBody String getByIdAndPlay(@PathVariable int id) {
		System.out.println("asdasdasdas");
		return "redirect:/index.html?aaa=4";
	}

	
}
