package com.treehouse.model;

import java.util.List;
import java.util.ArrayList;

public class SongBook {
    private List<Song> mSongs;
    
    public SongBook() {
        mSongs = new ArrayList<Song>();
    }
    
    public void addSong(Song song) {
        mSongs.add(song);
    }
    
    public int songCount() {
        return mSongs.size();
    }
}