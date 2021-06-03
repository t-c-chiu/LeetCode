package medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {
	
	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
		undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
		undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
		double averageTime = undergroundSystem.getAverageTime("Paradise", "Cambridge");// return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
		System.out.println(averageTime);
		averageTime = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
		System.out.println(averageTime);
		undergroundSystem.checkIn(10, "Leyton", 24);
		averageTime = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
		System.out.println(averageTime);
		undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
		averageTime = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
		System.out.println(averageTime);
	}
	
	static class UndergroundSystem {
		Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
		Map<String, Pair<Integer, Integer>> checkOutMap = new HashMap<>();
		
		public UndergroundSystem() {
		}
		
		public void checkIn(int id, String stationName, int t) {
			checkInMap.put(id, new Pair<>(stationName, t));
		}
		
		public void checkOut(int id, String stationName, int t) {
			Pair<String, Integer> checkIn = checkInMap.get(id);
			String route = checkIn.getKey() + "-" + stationName;
			Pair<Integer, Integer> checkOut = checkOutMap.getOrDefault(route, new Pair<>(0, 0));
			checkOutMap.put(route, new Pair<>(checkOut.getKey() + (t - checkIn.getValue()), checkOut.getValue() + 1));
			checkInMap.remove(id);
		}
		
		public double getAverageTime(String startStation, String endStation) {
			String route = startStation + "-" + endStation;
			Pair<Integer, Integer> checkOut = checkOutMap.get(route);
			return (double) checkOut.getKey() / checkOut.getValue();
		}
	}
}
