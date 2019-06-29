import java.util.Random;
import java.util.ArrayList;
public class RiderEvent implements Event{
	
	private int busStop;
	
	public RiderEvent(int rBusStop) {
		busStop = rBusStop;
	}
	
	public void run() {
		Random  generator = new Random();
		int random = generator.nextInt(19);
		
		double interval = 120 + Stop.arrivalPercents[random] * 120;
		int[] popularStops = {0,1,29,14,15,16};
		
		// checks if were spawning a rider in a downtown spot
		for (int k:popularStops) {
			if (k == busStop) {
				interval /= 2;
				break;
			}
		}
		
		// Rush hour/ off hours
		//interval /= 2; // uncomment this line and change interval amount to simulate off-hours/peak hours
		// creates a new rider object and adds it to the queue and adds a new rider event to the agenda
		Rider rider = new Rider(busStop);
		BusSim.agenda.add(new RiderEvent(busStop),interval);
		Stop.busStops[busStop].add(rider);
		System.out.println("Rider event at bus stop:" + busStop +" Time is: " + BusSim.agenda.getCurrentTime() + " dropoff stop is " + rider.getDropoff());
	}

}