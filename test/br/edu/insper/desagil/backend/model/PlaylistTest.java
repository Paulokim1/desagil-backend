package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private Playlist playlist;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	private Artist artist;
	private static double DELTA = 0.000001;

	@BeforeEach
	void setUp() {
		playlist = new Playlist(1);
		
	}

	@Test
	void testRoundDownToZero() {
		playlist.putRating("User 1", 1);
		playlist.putRating("User 2", 2);
		playlist.putRating("User 3", 3);
		playlist.putRating("User 4", 3);
		assertEquals(2.0, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		playlist.putRating("User 1", 1);
		playlist.putRating("User 2", 2);
		playlist.putRating("User 3", 1);
		assertEquals(1.5, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		playlist.putRating("User 1", 1);
		playlist.putRating("User 2", 2);
		playlist.putRating("User 3", 2);
		assertEquals(1.5, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundUpToOne() {
		playlist.putRating("User 1", 1);
		playlist.putRating("User 2", 1);
		playlist.putRating("User 3", 2);
		playlist.putRating("User 4", 3);
		assertEquals(2.0, playlist.averageRatings(), DELTA);
	}
}
