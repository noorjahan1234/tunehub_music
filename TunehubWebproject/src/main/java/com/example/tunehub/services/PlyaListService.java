package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entites.PlayList;

public interface PlyaListService 
{

	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchPlaylist();
	 
}
