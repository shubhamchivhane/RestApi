package com.resfful.webservice.restfulapi.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resfful.webservice.restfulapi.dao.UserDao;
import com.resfful.webservice.restfulapi.exception.UserNotFoundException;
import com.resfful.webservice.restfulapi.model.User;

@RestController
public class UserController {
	
	//private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao dao;
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
//	@GetMapping("/hello")
//	public User Show()
//	{
//		//return new User("hello");
//		return null;
//	}

	@GetMapping("/hello/path-variable/{name}")
	public User Show(@PathVariable String name)
	{
		return new User(1, "shubham", new Date());
	}

	@GetMapping("/hello/{id}")
	public User getUser(@PathVariable int id)
	{
		User userInfo= dao.findOne(id);
		if(userInfo  == null)
		{
			throw new UserNotFoundException("id :"+id);
		}
		return null;
	}
	
	@GetMapping("/hello")
	public List<User> getAllUser()
	{
		return dao.findAll();
	}
	
	@PostMapping("/hello")
	public String createUser(@Valid @RequestBody User user)
	{  
		Boolean value=dao.save(user);
		if(value)
		{
			return "user inserted :"+user.getName();
		}
		else
		{
			return "user not inserted :"+user.getName();
		}
			
		//return null;
	}
	
}
