import java.util.Random;
import java.util.ArrayList;
public class Rider {
	private int pickup;
	private int dropoff;
	private double spawnTime;
	private String type;
	private double travelTime;

	public Rider(int rPickup) {
		pickup = rPickup;
		Random  generator = new Random();
		dropoff = Stop.stopSelect[generator.nextInt(36)];
		// This checks if the drop off location is an eligible number, and finds a new one until it is
		if (pickup < 15) {
			while (dropoff <= pickup || dropoff > 15) {
				dropoff = Stop.stopSelect[generator.nextInt(36)];
			}
		} else if (pickup == 29) {
			dropoff = 0;
		} else {
			while (dropoff <= pickup){
				dropoff = Stop.stopSelect[generator.nextInt(36)];
			}
		}
		spawnTime = BusSim.agenda.getCurrentTime(); // keep track of spawn time for many of the statistics
		// I use this to differ between the riders who are willing to get on express bus
		if (dropoff == 0 || dropoff == 4 || dropoff == 8 || dropoff == 12|| dropoff == 1 || dropoff == 14 || dropoff == 15 || dropoff == 16 || dropoff ==20 || dropoff == 24 || dropoff ==28|| dropoff == 29) type = "express";
		else type = "normal";
	}
	
	public String getType() {
		return type;
	}
	public int getPickup() {
		return pickup;
	}
	
	public int getDropoff() {
		return dropoff;
	}
	
	
	public double getSpawnTime() {
		return spawnTime;
	}
	
	
}