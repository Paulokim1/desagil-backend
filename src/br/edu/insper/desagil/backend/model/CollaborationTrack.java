package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track {
	
	private List<Artist> collaborators;

	public CollaborationTrack(Artist artist,List<Artist> collaborators, String name,int duracao) {
		super(artist, name, duracao);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName() {
		List<String> listaString = new ArrayList<>();
		for (Artist artist : this.collaborators) {
			listaString.add(artist.getNome());
		}
		String colab = String.join(", ", listaString);
		String artistName = super.getArtist().getNome();
		
		return artistName + " (feat. " + colab + ")";
	}
}
