package com.resfful.webservice.restfulapi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.resfful.webservice.restfulapi.model.User;



@Component
public class UserDao {

	public static List<User> users= new ArrayList<>();
	
	public static int userCount=3;
	
	static
	{
		users.add(new User(1,"SHUBHAM",new Date()));
		users.add(new User(2,"sagar",new Date()));
		users.add(new User(3,"vaibhav",new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public Boolean save(User user)
	{
		System.out.println("inside save dao" +user.getName()+""+user);
		if(user.getId()==null)
		{
			user.setId(++userCount);
		}
		try {
		users.add(user);
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
			
		}
		return null;
	}
	
}
