package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entites.PlayList;
import com.example.tunehub.repositories.PlayListRepository;

@Service
public class PlayListImplemention implements PlyaListService
{

	@Autowired
	PlayListRepository prepo;

	@Override
	public void addPlaylist(PlayList playlist)
	{
		prepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchPlaylist() {
		return prepo.findAll();
	}
}
