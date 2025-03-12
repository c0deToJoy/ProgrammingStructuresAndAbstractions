import java.util.Arrays;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	
	private static final String INFO_DELIMITER = "; ";
	private static final String TIME_DELIMITER = ":";
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_TIME = 2;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	
	public Song(String info) {
		
	    String[] parts = info.split(INFO_DELIMITER);

	    title = parts[IDX_TITLE];
	    artist = parts[IDX_ARTIST];

	    String[] timeParts = parts[IDX_TIME].split(TIME_DELIMITER);

	    time = new int[timeParts.length];

	    if (timeParts.length == 1) {
	        time[0] = Integer.parseInt(timeParts[0]);
	    } 
	    else if (timeParts.length == 2) {
	        time[0] = Integer.parseInt(timeParts[1]);
	        time[1] = Integer.parseInt(timeParts[0]);
	    }
	    else if (timeParts.length == 3) {
	        time[0] = Integer.parseInt(timeParts[2]);
	        time[1] = Integer.parseInt(timeParts[1]);
	        time[2] = Integer.parseInt(timeParts[0]);
	    }
	    
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}

	@Override
	public String toString() {
	    if (time.length == 1) {
	        return String.format("%s; %s; %02d", title, artist, time[0]);
	    }
	    else if (time.length == 2) {
	        return String.format("%s; %s; %d:%02d", title, artist, time[1], time[0]);
	    }
	    else if (time.length == 3) {
	        return String.format("%s; %s; %d:%02d:%02d", title, artist, time[2], time[1], time[0]);
	    }
	    return title + "; " + artist + "; " + 0;
	}
	
	
}
