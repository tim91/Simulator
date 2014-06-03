package org.tstraszewski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainPageController")
public class MainController{
	
	@RequestMapping(value={"/","/index.htm","/main.htm","/main"})
	public ModelAndView mainPage(){
		
		ModelAndView mav = new ModelAndView("index");
		return mav;
	} 
 
	
	@RequestMapping(value="/historyPage.htm")
	public ModelAndView historyPage(){
		
		ModelAndView mav = new ModelAndView("history");
		return mav;
	} 
}
