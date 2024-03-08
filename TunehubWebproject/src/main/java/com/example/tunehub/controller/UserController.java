package com.example.tunehub.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tunehub.entites.Song;
import com.example.tunehub.entites.User;
import com.example.tunehub.services.SongService;
import com.example.tunehub.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController 
{
	@Autowired
	UserService userv;
	
	@Autowired
	SongService songserv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user)		
	{
		//check email persent or not
		boolean userstaus=userv.emailExists(user.getEmail());
		if(userstaus==true)
		{
		userv.addUser(user);
		//System.out.println("user is exist");
		return "registerSucces";
		}
		else
		{
			//System.out.println("user is already exist");
			return "home";
		}
			
	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password, HttpSession session)
	{
		//invoking the validuser() in service
		if(userv.validateUser(email,password) == true)
		{
			session.setAttribute("email", email);
			//checking whether the user is admin or customer
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else
		{
			return "loginfail";
		}
	}
	@GetMapping("/exploreSong")
	public String exploreSongs(HttpSession session, Model model)
	{
		String email = (String) session.getAttribute("email");
		User user=userv.getUser(email);
		
		boolean userStatus=user.isPremium();
		//if it is true displaying the song otherwise displaying the payment page
		if(userStatus == true) {
			List<Song> songlist= songserv.fetchAllSong();
			model.addAttribute("songlist", songlist);
		
			return "displaysong";
		}
		else {
		return "payment";
		}
	}
}
