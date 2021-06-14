package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Track track;
	private CollaborationTrack colabTrack;
	private List<Artist> listaColab;
	private Artist artist;
	@BeforeEach
	void setUp() {
		artist = new Artist("Hashi");
		listaColab = new ArrayList<>();
	}

	@Test
	void testZeroSeconds() {
		track = new Track(artist, "CRUD", 0);
		
		assertEquals("0:00", track.getDurationString());
	}

	@Test
	void testFiveSeconds() {
		track = new Track(artist, "CRUD", 5);
		assertEquals("0:05", track.getDurationString());
	}

	@Test
	void testTwentyFiveSeconds() {
		track = new Track(artist, "CRUD", 25);
		assertEquals("0:25", track.getDurationString());
	}

	@Test
	void testOneMinuteZeroSeconds() {
		track = new Track(artist, "CRUD", 60);
		assertEquals("1:00", track.getDurationString());
	}

	@Test
	void testOneMinuteFiveSeconds() {
		track = new Track(artist, "CRUD", 65);
		assertEquals("1:05", track.getDurationString());
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		track = new Track(artist, "CRUD", 85);
		assertEquals("1:25", track.getDurationString());
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		track = new Track(artist, "CRUD", 120);
		assertEquals("2:00", track.getDurationString());
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		track = new Track(artist, "CRUD", 125);
		assertEquals("2:05", track.getDurationString());
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		track = new Track(artist, "CRUD", 145);
		assertEquals("2:25", track.getDurationString());
	}

	@Test
	void testOneCollaborator() {
		listaColab.add(new Artist("Antonio"));
		colabTrack = new CollaborationTrack(artist, listaColab, "Scrum",90);
		assertEquals("Hashi (feat. Antonio)", colabTrack.getFullArtistName());
	}

	@Test
	void testTwoCollaborators() {
		listaColab.add(new Artist("Antonio"));
		listaColab.add(new Artist("Miranda"));
		colabTrack = new CollaborationTrack(artist, listaColab, "Comp Rocks",120);
		assertEquals("Hashi (feat. Antonio, Miranda)", colabTrack.getFullArtistName());
	}
}
