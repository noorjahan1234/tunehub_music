package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entites.Song;
import com.example.tunehub.repositories.SongRepository;

@Service
public class SongServiceImplemention implements SongService
{
	@Autowired
	SongRepository srepo;
	
	@Override
	public String addSongs(Song song) {
		srepo.save(song);
		return "Song is added";
	}


	@Override
	public boolean songExists(String name) {
		Song song=srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	@Override
	public List<Song> fetchAllSong() {
		List<Song> songlist=srepo.findAll();
		return songlist;
	}


	@Override
	public Song updateSong(Song song) {
		return srepo.save(song);
	}
}
