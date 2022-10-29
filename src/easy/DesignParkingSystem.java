package easy;

public class DesignParkingSystem {
	
	public static void main(String[] args) {
		ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
		parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
		parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
		parkingSystem.addCar(3); // return false because there is no available slot for a small car
		parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
	}
	
	static class ParkingSystem {
		
		int[] lots;
		
		public ParkingSystem(int big, int medium, int small) {
			lots = new int[]{big, medium, small};
		}
		
		public boolean addCar(int carType) {
			if (lots[carType - 1] == 0) {
				return false;
			}
			lots[carType - 1]--;
			return true;
		}
	}
}
