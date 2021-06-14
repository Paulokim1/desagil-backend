package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	public Playlist(int id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}
	public int getId() {
		return id;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public Map<String, Integer> getRatings() {
		return ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String user, int rating) {
		this.ratings.put(user, rating);
	}
	
	public double averageRatings() {
		double soma = 0.0;
		for (int rating : this.ratings.values()) {
			soma += rating;
		}
		
		double media = soma/this.ratings.size();
		
		int i = (int) media;
		double d = media - i;
		
		if (d < 0.26) {
			d = 0.0;
		}
		else if (d >= 0.26 && d<0.74) {
			d = 0.5;
		}
		else {
			d = 1.0;
		}
		double mediaFinal = i + d;
		return mediaFinal;
	}
	
	
	
	
	

}
