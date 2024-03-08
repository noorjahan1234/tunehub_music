package com.example.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entites.Song;

public interface SongRepository extends JpaRepository<Song, Integer>
{
	public Song findByName(String name);


}