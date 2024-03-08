package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entites.Song;
import com.example.tunehub.services.SongService;

@Controller
public class SongController 
{
	@Autowired
	SongService songserv;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song)
	{
		boolean status=songserv.songExists(song.getName());
		if(status==false)
		{
			songserv.addSongs(song);
		return "songsuccess";
		}
		else
		{
			return "songfail";
		}
	}
	@GetMapping("/map-viewsong")
	public String viewSong(Model model)
	{
		List<Song> songlist=songserv.fetchAllSong();
		model.addAttribute("songlist", songlist);
		return "displaysong";
	}
	@GetMapping("/vies-song")
	public String viewCustomerSong(Model model)
	{
		//check condition false print payment view song otherwise true then display song
		boolean prieCustomerStatus=true;
		if(prieCustomerStatus==true)
		{
			List<Song> songlist=songserv.fetchAllSong();
			model.addAttribute("songlist", songlist);
			return "displaysong";
		}
		else
		{
			return "makepayment";
		}
	}
}
