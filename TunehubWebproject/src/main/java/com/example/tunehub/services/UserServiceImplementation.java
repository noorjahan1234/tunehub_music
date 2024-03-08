package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entites.User;
import com.example.tunehub.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	UserRepository urepo;
	@Override
	public String addUser(User user)
	{
		urepo.save(user);
		return "User is create and saved";
	}
	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email)== null)
		{
		return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		User user=urepo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password))
		{
		return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		return (urepo.findByEmail(email).getRole());
	}
	@Override
	public User getUser(String email) {
		return urepo.findByEmail(email);
	}
	@Override
	public void updateUser(User user) {
		urepo.save(user);
		
	}

}
