package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entites.Song;

public interface SongService 
{
	public String addSongs(Song song);
	public boolean songExists(String name);
	public List<Song> fetchAllSong();
	public Song updateSong(Song song);
	
}
