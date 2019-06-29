// Bus event

public class BusEvent implements Event {
	private int busStop;
	private Bus bus;
	private int countOff=0;
	public static double countOn=0;
	private int queue;
	private int[] express = {0,1,4,8,12,14,15,16,20,24,28,29};
	private int[] normal = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
	private int skip;

	public BusEvent(int theBusStop, Bus theBus) {
		busStop = theBusStop;
		bus = theBus;
	}
	

	// First thing is removing riders at bus stop 
	// then it checks each rider in queue to see if the rider should board bus
	// then calculates the next bus stop and schedules it at the appropriate time
	public void run() {
		countOn = 0;
		for (int k=0;k < bus.getRidersOff(busStop).size();k++) {
			Statistics.totalTravelTime += BusSim.agenda.getCurrentTime() - bus.getRidersOff(busStop).get(k).getSpawnTime();
		}
		countOff = bus.removeRidersAtStop(busStop).size();
		System.out.println(bus.getType() + " bus drops off " + countOff + " rider(s) at bus stop " + busStop + ". Time is: " + BusSim.agenda.getCurrentTime());
		
		Statistics.countStops++;
		if (Stop.busStops[busStop].length() > Statistics.maxQueueLength) {
			Statistics.maxQueueLength = Stop.busStops[busStop].length();
			Statistics.theMaxQueue = busStop;
		}
		
		int full = Stop.busStops[busStop].length();

		// Boarding bus
	
			// Normal Bus
		if (bus.getType().equals("normal")) {
			// Add as many riders as possible onto the normal bus
			for (int k=0;k< full;k++) {
				Statistics.numOfRiders++;
				if (bus.isFull() == true) {
					System.out.println("Bus is full");
					break;
				} 
				if (BusSim.agenda.getCurrentTime() - Stop.busStops[busStop].getFront().getSpawnTime() > Statistics.maxWaitTime) {
					Statistics.maxWaitTime = BusSim.agenda.getCurrentTime() - Stop.busStops[busStop].getFront().getSpawnTime();
					Statistics.maxWaitQueue = busStop;
				}
				Statistics.totalWaitTime+= BusSim.agenda.getCurrentTime()- Stop.busStops[busStop].getFront().getSpawnTime();
				countOn++;
				Statistics.numOfRiders++;
				
				bus.addRider((Rider) Stop.busStops[busStop].remove());// adding rider
			}
			Statistics.normalEvent++;
			Statistics.normalBusCap+= bus.getSize();
			// Express Bus
			// I check each rider in queue, if they are express rider, they get added to bus...
			// otherwise each rider gets added to a temporary queue
			// I do this because i cant get the express riders of the middle of the queue
			// and have to make a temp queue for all the normal riders, and add them back to the main queue at the end
		} else if (bus.getType().equals("express")) {
			Q2 temp = new Q2();
			for(int k=0;k < full;k++) {
				if (bus.isFull() == true) {
					System.out.println("Bus is full");
					break;
					// checks front of queue
				} else if (Stop.busStops[busStop].getFront().getType().equals("express")) {
					if (BusSim.agenda.getCurrentTime() - Stop.busStops[busStop].getFront().getSpawnTime() > Statistics.maxWaitTime) {
						Statistics.maxWaitTime = BusSim.agenda.getCurrentTime() - Stop.busStops[busStop].getFront().getSpawnTime();
						Statistics.maxWaitQueue = busStop;
					}
					Statistics.totalWaitTime+= BusSim.agenda.getCurrentTime() - Stop.busStops[busStop].getFront().getSpawnTime();
					bus.addRider((Rider) Stop.busStops[busStop].remove());// adding rider
					countOn++;
					Statistics.numOfRiders++;
				
				} else { // adding normal riders to temp queue
					temp.add(Stop.busStops[busStop].remove());
				}	

			}
			int length = temp.length();
			// adding normal riders back into queue in the same order as they were before
			for (int k=0;k<length;k++) {
				Stop.busStops[busStop].add(temp.remove());
			}
			Statistics.expressBusCap += bus.getSize();
			Statistics.expressEvent++;
		}
			
		// Done boarding bus
		Statistics.countCap += bus.getSize();
		
		// Getting next bus stop and schedule time
		// normal bus
		if (bus.getType().equals("normal")) {
			if (busStop == 29) {
				busStop = 0;
			} else {
				busStop++;
			}
			// checks time it takes for riders to get on and off and schedules next event accordingly
			if ((3 * countOn) + (2 * countOff) >15) {
				BusSim.agenda.add(new BusEvent(busStop,bus),240 + 3*countOn + 2*countOff);
			} else {
				BusSim.agenda.add(new BusEvent(busStop,bus),240 + 15);
			}
			
		// express bus
		// calculates how many stops are skipped and what the next bus stop is
		} else if (bus.getType().equals("express")) {
			if (busStop == 0 || busStop == 14 || busStop == 15 || busStop == 28 || busStop == 29) {
				skip = 1;
			} else if (busStop == 1) {
				skip = 3;
			} else if (busStop == 12) {
				skip = 2;
			} else {
				skip = 4;
			}
			
			
			if (busStop == 29) {
				busStop = 0;
			} else {
				// goes through express busstops and gets the next one
				for(int k=0;k < express.length;k++) {
					if (express[k] == busStop) {
						busStop = express[k+1];
						break;
					}
				}
			}
			// checks time it takes for riders to get on and off and schedules next event accordingly
			if ((3 * countOn) + (2 * countOff) >15) {
				BusSim.agenda.add(new BusEvent(busStop,bus),skip * 240 + 3*countOn + 2*countOff);
			} else {
				BusSim.agenda.add(new BusEvent(busStop,bus),skip * 240 + 15);
			}
		}

	}
}



