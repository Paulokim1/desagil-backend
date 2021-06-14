package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration;
	public Track(Artist artist, String name, int duracao) {
		this.artist = artist;
		this.name = name;
		this.duration = duracao;
	}
	public Artist getArtist() {
		return artist;
	}
	public String getName() {
		return name;
	}
	public int getDuration() {
		return duration;
	}
	
	public String getDurationString() {
		if (this.duration < 60) {
			String durationString = Integer.toString(this.duration);
			if (this.duration < 10) {
				durationString = "0" + Integer.toString(this.duration);
			}
			else {
				durationString = Integer.toString(this.duration);
			}
			return "0:"+durationString;
		}
		else {
			int min = duration/60;
			int seg = duration % 60;
			String stringMin = "";
			String stringSeg = "";
			
			stringMin = Integer.toString(min);
			
			if (seg < 10) {
				stringSeg = "0" + Integer.toString(seg);
			}
			else {
				stringSeg = Integer.toString(seg);
			}
			
			return stringMin + ":" + stringSeg; 
		}
	}
	
	public String getFullArtistName() {
		return this.artist.getNome();
	}
	
	
	
}
