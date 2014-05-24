package org.tstraszewski.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tstraszewski.service.UserService;

@Controller
@RequestMapping("/documentation")
public class DocumentationController extends HttpServlet  {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void getDocumentation(){
		System.out.println("Dokumentacja");
	}

}
