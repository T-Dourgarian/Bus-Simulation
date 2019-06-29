import java.util.ArrayList;
public class BusSim {
	public static PQ agenda = new PQ();
	
	public static void main(String[] args) {
		// creating rider events at each stop
		agenda.add(new RiderEvent(0),0);
		agenda.add(new RiderEvent(1),0);
		agenda.add(new RiderEvent(2),0);
		agenda.add(new RiderEvent(3),0);
		agenda.add(new RiderEvent(4),0);
		agenda.add(new RiderEvent(5),0);
		agenda.add(new RiderEvent(6),0);
		agenda.add(new RiderEvent(7),0);
		agenda.add(new RiderEvent(8),0);
		agenda.add(new RiderEvent(9),0);
		agenda.add(new RiderEvent(10),0);
		agenda.add(new RiderEvent(11),0);
		agenda.add(new RiderEvent(12),0);
		agenda.add(new RiderEvent(13),0);
		agenda.add(new RiderEvent(14),0);
		agenda.add(new RiderEvent(15),0);
		agenda.add(new RiderEvent(16),0);
		agenda.add(new RiderEvent(17),0);
		agenda.add(new RiderEvent(18),0);
		agenda.add(new RiderEvent(19),0);
		agenda.add(new RiderEvent(20),0);
		agenda.add(new RiderEvent(21),0);
		agenda.add(new RiderEvent(22),0);
		agenda.add(new RiderEvent(23),0);
		agenda.add(new RiderEvent(24),0);
		agenda.add(new RiderEvent(25),0);
		agenda.add(new RiderEvent(26),0);
		agenda.add(new RiderEvent(27),0);
		agenda.add(new RiderEvent(28),0);
		agenda.add(new RiderEvent(29),0);
		
		// creating bus Event, seemed the most even number of normal busses was about 11
		agenda.add(new BusEvent(0 , new Bus("normal")),0);
		agenda.add(new BusEvent(3 , new Bus("normal")),0);
		agenda.add(new BusEvent(6 , new Bus("normal")),0);
		agenda.add(new BusEvent(9 , new Bus("normal")),0);
		agenda.add(new BusEvent(12 , new Bus("normal")),0);
		agenda.add(new BusEvent(15, new Bus("normal")),0);
		agenda.add(new BusEvent(18 , new Bus("normal")),0);
		agenda.add(new BusEvent(21 , new Bus("normal")),0);
		agenda.add(new BusEvent(24 , new Bus("normal")),0);
		agenda.add(new BusEvent(27 , new Bus("normal")),0);
		agenda.add(new BusEvent(29 , new Bus("normal")),0);

		// Uncomment to add express busses, make sure to change the starting bus stop according to how many are present
		//agenda.add(new BusEvent(0 , new Bus("express")),0);
		//agenda.add(new BusEvent(8 , new Bus("express")),0);
		//agenda.add(new BusEvent(12 , new Bus("express")),0);
		//agenda.add(new BusEvent(15 , new Bus("express")),0);
		//agenda.add(new BusEvent(20 , new Bus("express")),0);
		//agenda.add(new BusEvent(24 , new Bus("express")),0);
		//agenda.add(new BusEvent(28 , new Bus("express")),0);
		
		// Actual running of program
		// rush hour T = 10800 (3 hours)
		// normal time T = 18000(5 hours)
		// off hours T = 25200 (7 hours)
		while (agenda.getCurrentTime() < 18000) {
			agenda.remove().run();
		}
		// Stats
		System.out.println("------- Statistics --------");
		System.out.println("Average bus capcity: " + Statistics.countCap / Statistics.countStops);
		System.out.println("Average capacity of normal bus is " + (Statistics.normalBusCap/Statistics.normalEvent));
		System.out.println("Average capacity of express bus is " + (Statistics.expressBusCap/Statistics.expressEvent));
		System.out.println("Average wait time: " + (Statistics.totalWaitTime / Statistics.numOfRiders)/60 + " minutes");
		System.out.println("Maximum queue length is: " + Statistics.maxQueueLength + " at stop " + Statistics.theMaxQueue);
		System.out.println("Average travel time is " + (Statistics.totalTravelTime / Statistics.numOfRiders)/60 + " minutes");
	
	}
}






