import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Convert {

	private final static String HEADER = "Time,Latitude,Longitude";
	
	public static void convertFile(String filename) throws IOException {
		
		String csvName = filename.substring(0,filename.indexOf(".")) + ".csv";
		FileWriter csv = new FileWriter(csvName);
		Scanner reader = new Scanner(new File(filename));
		
		int time = 0;
		double lat = 0.0;
		double lon = 0.0;
		csv.write(HEADER + "\n");
		
		while(reader.hasNextLine()) {
			
			//Read line of og file
			String coords = reader.nextLine();
			
			if (coords.contains("<trkpt")) {
			
				//Extract doubles without anomalies
				double[] latAndLon = getLatAndLon(coords);
			
				//Assign to lat + lon
				lat = latAndLon[0];
				lon = latAndLon[1];
			
				//Write time,lat,lon
				csv.write(time + "," + lat + "," + lon + "\n");
			
				//Inc time +5
				time += 5;

			}
			
		}
		
		reader.close();
		csv.close();
	
	}
	
	public static double[] getLatAndLon(String coords) {
	    double[] latAndLon = new double[2];
	    int index = 0;
	    StringBuilder currentCoord = new StringBuilder();

	    boolean isLat = false;

	    for (int i = 0; i < coords.length(); i++) {
	        char c = coords.charAt(i);
	        if (c == '\"') {
	            isLat = !isLat;
	        } 
	        else if (isLat && (Character.isDigit(c) || c == '.' || c == '-')) {
	            currentCoord.append(c);
	        } 
	        else if (!isLat && currentCoord.length() > 0) {
	            latAndLon[index++] = Double.parseDouble(currentCoord.toString());
	            currentCoord.setLength(0);
	        }
	    }

	    if (!isLat && currentCoord.length() > 0) {
	        latAndLon[index] = Double.parseDouble(currentCoord.toString());
	    }

	    return latAndLon;
	
	}
}
