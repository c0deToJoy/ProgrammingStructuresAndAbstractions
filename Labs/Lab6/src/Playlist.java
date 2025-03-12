import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Playlist {

    private ArrayList<Song> songs;

    public Playlist() {
    	
    	// TODO: Initialize the songs field.
        this.songs = new ArrayList<>();
        
    }

    public Playlist(String filename) {
    	
        this();
        addSongs(filename);
        
    }

    public int getNumSongs() {
        return songs.size();
    }

    public Song getSong(int index) {
    	
        if (index < 0 || index >= getNumSongs()) {
            return null;
        }
        return songs.get(index);
        
    }

    public Song[] getSongs() {
        return songs.toArray(new Song[0]);
    }

    public boolean addSong(Song song) {
        return addSong(getNumSongs(), song);
    }

    public boolean addSong(int index, Song song) {
    	
    	// TODO: Update the Lab 3 method.
        if (song == null || index < 0 || index > getNumSongs()) {
            return false;
        }
        songs.add(index, song);
        return true;
        
    }

    public int addSongs(Playlist playlist) {
    	
    	// TODO: Update the Lab 3 method.
        if (playlist == null) {
            return 0;
        }
        int added = 0;
        for (Song song : playlist.getSongs()) {
            if (addSong(song)) {
                added++;
            }
        }
        return added;
        
    }

    public int addSongs(String filename) {
    	
        int added = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Song song = new Song(line);
                if (addSong(song)) {
                    added++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return added;
        
    }

    public Song removeSong() {
        return removeSong(getNumSongs() - 1);
    }

    public Song removeSong(int index) {
    	
    	// TODO: Update the Lab 3 method.
        if (index < 0 || index >= getNumSongs()) {
            return null;
        }
        return songs.remove(index);
        
    }

    public void saveSongs(String filename) {
    	
        try (FileWriter writer = new FileWriter(filename)) {
            for (Song song : songs) {
                writer.write(song.toString());
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (Song song : songs) {
            joiner.add(song.toString());
        }
        return joiner.toString();
    }

    public int[] getTotalTime() {
    	
        int totalSeconds = 0;
        for (Song song : songs) {
            int[] time = song.getTime();
            
            if(time.length == 1) {
            	totalSeconds += time[0];
            }
            else if (time.length == 2) {
            	totalSeconds += time[0] + time[1] * 60;
            }
            else if (time.length == 3) {
            	totalSeconds += time[0] + time[1] * 60 + time[2] * 3600;
            }
        }

        if (totalSeconds < 60) {
            return new int[]{totalSeconds};
        } else if (totalSeconds < 3600) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            return new int[]{seconds, minutes};
        } else {
            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;
            return new int[]{seconds, minutes, hours};
        }
        
    }
    
}
