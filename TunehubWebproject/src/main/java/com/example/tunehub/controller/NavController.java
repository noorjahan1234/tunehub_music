package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController
{
	@GetMapping("/mapregister")
	public String mapregister()
	{
		return "register";
		
	}
	@GetMapping("/maplogin")
	public String maplogin()
	{
		return "login";
		
	}
	@GetMapping("/map-songs")
	public String songMapping()
	{
		return "addsong";		
	}
	@GetMapping("/samplePayment")
	public String samplePayment()
	{
		return "samplePayment";		
	}
}
