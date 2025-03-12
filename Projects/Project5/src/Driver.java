import java.io.FileNotFoundException;
import java.io.IOException;
import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver {
	
	// Declare class data
    private static JMapViewer mapViewer;
    private static ArrayList<TripPoint> trip;
    private static int animationTime;
    private static Timer timer;
    private static ImageIcon racoonIcon = new ImageIcon("raccoon.png");
    private static Image racoon = racoonIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private static IconMarker racoonMarker;

    public static void main(String[] args) throws FileNotFoundException, IOException {

    	// Read file and call stop detection
    	TripPoint.readFile("triplog.csv");
        TripPoint.h2StopDetection();
    	
    	// Set up frame, include your name in the title
        JFrame map = new JFrame("Joy Mosisa");
        map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = 600;
        int y = 400;
        map.setSize(x, y);
        map.setLayout(new BorderLayout());
        
        // Set up Panel for input selections
        JPanel mapPanel = new JPanel();
    	
        // Play Button
        JButton playButton = new JButton("Play");
    	
        // CheckBox to enable/disable stops
        JCheckBox stopsCheckBox = new JCheckBox("Include Stops");
    	
        // ComboBox to pick animation time
        String[] comboBoxTimes = { "Animation Time", "15", "30", "60", "90" };
        JComboBox<String> time = new JComboBox<String>(comboBoxTimes);
    	
        // Add all to top panel
        mapPanel.add(time);
        mapPanel.add(stopsCheckBox);
        mapPanel.add(playButton);
        map.add(mapPanel, BorderLayout.NORTH);
        
        // Set up mapViewer
        mapViewer = new JMapViewer();
        mapViewer.setTileSource(new OsmTileSource.TransportMap());
        map.add(mapViewer, BorderLayout.CENTER);
        
        // Add listeners for GUI components and animate the trip based on selections from the GUI components
        ActionListener playListener = new ActionListener() {
            
	        public void actionPerformed(ActionEvent e) {
	                
	        	mapViewer.removeAllMapMarkers();
	            mapViewer.removeAllMapPolygons();
	               
	            if (timer != null) {
	            	timer.stop();
	            }
	                
	            animationTime = Integer.parseInt((String) time.getSelectedItem());
	            int timerDelay = animationTime * 100 / TripPoint.getTrip().size();
	                
	            if (stopsCheckBox.isSelected()) {
	            	trip = TripPoint.getTrip();
	            }
	            else {
	            	trip = TripPoint.getMovingTrip();
	            }
	                
	            timer = new Timer(timerDelay, new ActionListener() {
		            private int index = 1;
		
		            public void actionPerformed(ActionEvent e) {
		            	
		            	if (index == 1) {
		                	Coordinate start = new Coordinate(trip.get(0).getLat(), trip.get(0).getLon());
		                	racoonMarker = new IconMarker(start, racoon);
		                	mapViewer.addMapMarker(racoonMarker);
		                	mapViewer.removeMapMarker(racoonMarker);
		                }
		                
		            	if (index < trip.size()) {
		                	if (racoonMarker != null) {
		                    	mapViewer.removeAllMapMarkers();
		                    }
		                    
		                	Coordinate curr = new Coordinate(trip.get(index).getLat(), trip.get(index).getLon());
		                    Coordinate prev = new Coordinate(trip.get(index - 1).getLat(), trip.get(index - 1).getLon());
		                    
		                    MapPolygonImpl point = new MapPolygonImpl(prev, prev, curr);
		                    point.setColor(Color.RED);
		                    point.setBackColor(Color.RED);
		                    IconMarker racoonMarker = new IconMarker(curr, racoon);
		                    mapViewer.addMapMarker(racoonMarker);
		                    mapViewer.addMapPolygon(point);
		                    ++index;
		            	}
		            	else {
		                	((Timer) e.getSource()).stop();
		            	}
		            	
		            }
		            
	            });
	            
	            timer.start();
	
	        }
	        
        };

        playButton.addActionListener(playListener);

        // Set the map center and zoom level
        Coordinate Center = new Coordinate(34, -107);
        mapViewer.setDisplayPosition(Center, 5);
        map.setVisible(true);
        mapViewer.setMapMarkerVisible(true);
        
    }
  
}