package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entites.PlayList;
import com.example.tunehub.entites.Song;
import com.example.tunehub.services.PlyaListService;
import com.example.tunehub.services.SongService;

@Controller
public class PlayListControler 
{

	@Autowired
	PlyaListService pserv;
	
	@Autowired
	SongService sservi;
	
	@GetMapping("/createplaylist")
	public String createPlayList(Model model)
	{
		//Fetching the song using song service
		List<Song> songlist=sservi.fetchAllSong();
		//Adding the song in the model
		model.addAttribute("songlist", songlist);
		//sending create play list
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist)
	{
		//adding the play list
	
		pserv.addPlaylist(playlist);
		//update song table
		List<Song> songList=playlist.getSong();
		for(Song song : songList)
		{
			song.getPlaylist().add(playlist);
			sservi.updateSong(song);
		}
		return "playlistsuccess";
	}
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model)
	{
		List<PlayList> playlist=pserv.fetchPlaylist();
		//System.out.println(playlist);
		model.addAttribute("playlist", playlist);
		return "viewPlaylists";
	}
}
