package com.example.tunehub.entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String Artist;
	String Genre;
	String Link;
	@ManyToMany
	List<PlayList> playlist;
	public Song() 
	{
		super();
	}
	public Song(int id, String name, String artist, String genre, String link, List<PlayList> playlist) {
		super();
		this.id = id;
		this.name = name;
		Artist = artist;
		Genre = genre;
		Link = link;
		this.playlist = playlist;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) 
	{
		Artist = artist;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre)
	{
		Genre = genre;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) 
	{
		Link = link;
	}
	public List<PlayList> getPlaylist() 
	{
		return playlist;
	}
	public void setPlaylist(List<PlayList> playlist) 
	{
		this.playlist = playlist;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", Artist=" + Artist + ", Genre=" + Genre + ", Link=" + Link
				+ ", playlist=" + playlist + "]";
	}
	
}
