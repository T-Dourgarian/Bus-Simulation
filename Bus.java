import java.util.ArrayList;
public class Bus {
	private String type;
	private ArrayList<Rider> bus;
	
	public Bus(String bType) {
		bus = new ArrayList<Rider>();
		type = bType;
	}
	
	public int getSize() {
		return bus.size();
	}
	
	public String getType() {
		return type;
	}
	
	public void addRider(Rider r) {
		if (bus.size() < 50) {
			bus.add(r);
		} else {
			System.out.println("Bus is full");
		}
	}
	
	// method to remove riders and return an arraylist of them
	public ArrayList<Rider> removeRidersAtStop(int busStop) {
		ArrayList<Rider> dropOffs = new ArrayList<Rider>();
		
		for (int k = 0;k < 50 && k < bus.size();k++) {
			if (bus.get(k).getDropoff() == busStop) {
				dropOffs.add(bus.get(k));
				bus.remove(k);
			}
		}
		return dropOffs;
	}
	
	// A method to access the arraylist of riders who need to get off without actually removing them
	public ArrayList<Rider> getRidersOff(int busStop) {
		ArrayList<Rider> dropOffs = new ArrayList<Rider>();
			
		for (int k = 0;k < 50 && k < bus.size();k++) {
			if (bus.get(k).getDropoff() == busStop) {
				dropOffs.add(bus.get(k));
			}
		}
		return dropOffs;
	}
	
	public boolean isFull() {
		if(bus.size() >= 50) {
			return true;
		} else {
			return false;
		}
	}
}