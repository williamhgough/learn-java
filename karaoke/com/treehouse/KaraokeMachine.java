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