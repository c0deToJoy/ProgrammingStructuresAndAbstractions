import java.util.Arrays;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		int timeLength = time.length;
		int[] permTime = Arrays.copyOf(time, timeLength);
		this.time = permTime;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int[] getTime() {
		int timeLength = this.time.length;
		int[] permTime = Arrays.copyOf(this.time, timeLength);
		return permTime;
	}
	
}
