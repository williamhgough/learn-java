package com.treehouse;

import java.io.*;
import java.util.*;

import com.treehouse.model.Song;
import com.treehouse.model.SongBook;

public class KaraokeMachine {
	private SongBook mLibrary;
	private BufferedReader mReader;
	private Map<String, String> mMenu;

	public KaraokeMachine(SongBook library) {
		mLibrary = library;
		mReader = new BufferedReader(new InputStreamReader(System.in));
		mMenu = new HashMap<String, String>();
		mMenu.put("Add", "Add a new song to the library.");
		mMenu.put("Choose", "Choose a song!");
		mMenu.put("Quit", "Give up. Exit the program.");
	}
	
	private String promptAction() throws IOException {
		System.out.printf("There are %d songs available. Your options are: %n", mLibrary.songCount());
		for (Map.Entry<String, String> option : mMenu.entrySet()) {
			System.out.printf(" - %s - %s %n", option.getKey(), option.getValue());
		}
		System.out.print("What do you want to do? ");
		String choice = mReader.readLine();
		return choice.trim().toLowerCase();
	}
	
	private Song promptNewSong() throws IOException {
		System.out.print("Enter the artist's name: ");
		String artist = mReader.readLine();
		
		System.out.print("Enter the song's title: ");
		String title = mReader.readLine();
		
		System.out.print("Enter video URL: ");
		String url = mReader.readLine();
		return new Song(artist, title, url);
	}
	
	private String promptArtist() throws IOException {
		System.out.println("Available artists:");
		List<String> artists = new ArrayList<>(mLibrary.getArtists());
		int index = promptForIndex(artists);
		return artists.get(index);
	}
	
	private Song promptSongForArtist(String artist) throws IOException {
		List<Song> songs = mLibrary.getSongsForArtist(artist);
		List<String> songTitles = new ArrayList<>();
		
		for (Song song : songs) {
			songTitles.add(song.getTitle());
		}
		int index = promptForIndex(songTitles);
		return songs.get(index);
	}
	
	private int promptForIndex(List<String> options) throws IOException {
		int counter = 1;
		for(String option : options) {
			System.out.printf("%d.)  %s %n", counter, option);
			counter++;
		}
		String optionAsString = mReader.readLine();
		int choice = Integer.parseInt(optionAsString.trim());
		System.out.print("Your choice:   ");
		return choice - 1;
	}
	
	public void run() {
		String choice = "";
		do {
			try {
				choice = promptAction();
				switch (choice) {
					case "add":
						Song song = promptNewSong();
						mLibrary.addSong(song);
						System.out.printf("%s added! %n%n", song);
						break;
					case "choose":
						String artist = promptArtist();
						Song artistSong = promptSongForArtist(artistSong);
						System.out.printf("You chose:  %s %n", artistSong);
						break;
					case "quit":
						System.out.println("Thanks for playing!");
						break;
					default:
						System.out.printf("Unknown choice: %s. Try again! %n%n%n", choice);
				}
			} catch (IOException e) {
				System.out.printf("Problem with input: %s", e.getMessage());
				e.printStackTrace();
			}
		} while (!choice.equals("quit"));
	}
}