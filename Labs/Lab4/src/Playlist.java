import java.util.Arrays;

public class Playlist {

	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	public Playlist() {
		this.songs = new Song[MIN_CAPACITY]; 
	}
	
	public Playlist(int capacity) {
		if (capacity < MIN_CAPACITY) {
			this.songs = new Song[MIN_CAPACITY];
		}
		else {
			this.songs = new Song[capacity];
		}
	}
	
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
	    if (index < 0 || index >= this.numSongs) {
	        return null;
	    } 
	    else {
	        return songs[index];
	    }
	}

	public Song[] getSongs() {
		Song[] noSpace = Arrays.copyOf(songs, numSongs);
		return noSpace;
	}
	
	public boolean addSong(Song song) {
		return addSong(this.numSongs,song);
	}
	
	public boolean addSong(int index, Song song) {
	    if (this.numSongs >= this.songs.length || index < 0 || index > this.numSongs || song == null) {
	        return false;
	    }
	    for (int i = this.numSongs; i > index; i--) {
	        this.songs[i] = this.songs[i - 1];
	    }
	    this.songs[index] = song;
	    this.numSongs++;
	    return true;
	}
	
	public int addSongs(Playlist playlist) {
	    if (playlist == null) {
	        return 0;
	    }
	    else {
		    int availableSpace = this.songs.length - this.numSongs;
		    int songsToAdd = Math.min(availableSpace, playlist.getNumSongs());
		    for (int i = 0; i < songsToAdd; i++) {
		    	this.songs[this.numSongs + i] = playlist.getSong(i);
		    }
		    this.numSongs += songsToAdd;
		    return songsToAdd;
	    }
	}

	public Song removeSong() {
		return removeSong(this.numSongs - 1);
	}
	
	public Song removeSong(int index) {
	    if (index < 0 || index >= this.numSongs || this.songs[index] == null) {
	        return null;
	    }
	    Song removedSong = this.songs[index];
	    for (int i = index; i < this.numSongs - 1; i++) {
	    	this.songs[i] = this.songs[i + 1];
	    }
	    this.songs[this.numSongs - 1] = null;
	    this.numSongs--;
	    return removedSong;
	}

}
