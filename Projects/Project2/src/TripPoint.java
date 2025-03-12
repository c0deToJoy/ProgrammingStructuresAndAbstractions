import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TripPoint {
	
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip = new ArrayList<>();
	
	public TripPoint(int time, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public double getLat() {
		return this.lat;
	}
	
	public double getLon() {
		return this.lon;
	}
	
    public static ArrayList<TripPoint> getTrip() {
        ArrayList<TripPoint> copied = new ArrayList<>(trip);
        return copied;
    }
	
	public static double haversineDistance(TripPoint a, TripPoint b) {
		final double RADIUS = 6371.0;

	    double lat1 = Math.toRadians(a.getLat());
	    double lon1 = Math.toRadians(a.getLon());
	    double lat2 = Math.toRadians(b.getLat());
	    double lon2 = Math.toRadians(b.getLon());

	    double dLat = lat2 - lat1;
	    double dLon = lon2 - lon1;
	    double hsDistance = 2 * RADIUS * Math.asin(Math.sqrt(
	            Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	            Math.cos(lat1) * Math.cos(lat2) *
	            Math.sin(dLon / 2) * Math.sin(dLon / 2)));

	    return hsDistance;
	}
	
	public static double avgSpeed(TripPoint a, TripPoint b) {
		double totalTime =  Math.abs(a.getTime() - b.getTime()) / 60.0;
		double totalDist = haversineDistance(a, b);
		return totalDist/totalTime;
	}
	
    public static double totalTime() {
    	TripPoint point = trip.get(trip.size()-1);
    	double sumTimeHrs = point.getTime() / 60.0;
    	return sumTimeHrs;
    }

	
	public static double totalDistance() {
		double sumDistKms = 0.0;
		
		for(int i = 1; i < trip.size(); i++) {
			sumDistKms += haversineDistance(trip.get(i-1), trip.get(i));
		}
		
		return sumDistKms;
	}
	
	public static void readFile(String filename) throws NumberFormatException, FileNotFoundException, IOException {
	    if (!trip.isEmpty()) {
	        return;
	    }
	    
	    BufferedReader input = new BufferedReader(new FileReader(filename));
	    String line;
	    input.readLine();
	    
	    while((line = input.readLine()) != null) {
	        String[] parts = line.split(",");
	        int readTime = Integer.parseInt(parts[0].trim());
	        double readLat = Double.parseDouble(parts[1].trim());
	        double readLon = Double.parseDouble(parts[2].trim());
	        TripPoint readPoint = new TripPoint(readTime, readLat, readLon);
	        trip.add(readPoint);
	    }
	    input.close();
	}
	

}
