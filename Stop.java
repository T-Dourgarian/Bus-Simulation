public class Stop {
	
	
	// Csci 1933 Lecture Examples Q2.java
	// All the bus stop queues
	public static Q2 stop0 = new Q2();
	public static Q2 stop1 = new Q2();
	public static Q2 stop2 = new Q2();
	public static Q2 stop3 = new Q2();
	public static Q2 stop4 = new Q2();
	public static Q2 stop5 = new Q2();
	public static Q2 stop6 = new Q2();
	public static Q2 stop7 = new Q2();
	public static Q2 stop8 = new Q2();
	public static Q2 stop9 = new Q2();
	public static Q2 stop10 = new Q2();
	public static Q2 stop11 = new Q2();
	public static Q2 stop12 = new Q2();
	public static Q2 stop13 = new Q2();
	public static Q2 stop14 = new Q2();
	public static Q2 stop15 = new Q2();
	public static Q2 stop16 = new Q2();
	public static Q2 stop17= new Q2();
	public static Q2 stop18= new Q2();
	public static Q2 stop19= new Q2();
	public static Q2 stop20= new Q2();
	public static Q2 stop21= new Q2();
	public static Q2 stop22= new Q2();
	public static Q2 stop23= new Q2();
	public static Q2 stop24= new Q2();
	public static Q2 stop25= new Q2();
	public static Q2 stop26 = new Q2();
	public static Q2 stop27 = new Q2();
	public static Q2 stop28 = new Q2();
	public static Q2 stop29 = new Q2();

	// randomly select from this array to get drop off location and pickup location
	public static int[] stopSelect = {0, 0, 1, 1, 29, 29, 14, 14, 15, 15, 16, 16,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
	// array of all the bus stop queues
	public static Q2[] busStops = {stop0,stop1,stop2,stop3,stop4,stop5,stop6,stop7,stop8,stop9,stop10,stop11,stop12,stop13,stop14,stop15,stop16,stop17,stop18,stop19,stop20,stop21,stop22,stop23,stop24,stop25,stop26,stop27,stop28,stop29};
	// randomly select from this array in RiderEvent.java to get the random spawn time of the rider
	public static double[] arrivalPercents = {.75, .75, .5, .5, .5, .2, .2, .2, .2, 0, 0,-.2, -.2, -.2, -.5, -.5, -.5, -.75, -.75};
}