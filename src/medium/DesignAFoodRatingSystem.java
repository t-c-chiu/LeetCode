package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignAFoodRatingSystem {
	
	public static void main(String[] args) {
		FoodRatings foodRatings = new FoodRatings(
				new String[]{"czopaaeyl", "lxoozsbh", "kbaxapl"},
				new String[]{"dmnuqeatj", "dmnuqeatj", "dmnuqeatj"},
				new int[]{11, 2, 15});
		foodRatings.changeRating("czopaaeyl", 12);
		foodRatings.highestRated("dmnuqeatj");
		foodRatings.changeRating("kbaxapl", 8);
		foodRatings.changeRating("lxoozsbh", 5);
		foodRatings.highestRated("dmnuqeatj");
	}
	
	static class FoodRatings {
		
		Map<String, Integer> foodToRating;
		Map<String, String> foodToCuisine;
		Map<String, TreeSet<String>> cuisineToFoods;
		
		public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
			foodToRating = new HashMap<>();
			foodToCuisine = new HashMap<>();
			cuisineToFoods = new HashMap<>();
			int n = foods.length;
			for (int i = 0; i < n; i++) {
				String food = foods[i], cuisine = cuisines[i];
				int rating = ratings[i];
				foodToRating.put(food, rating);
				foodToCuisine.put(food, cuisine);
				cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
					int ratingA = foodToRating.get(a), ratingB = foodToRating.get(b);
					return ratingA == ratingB ? a.compareTo(b) : ratingB - ratingA;
				}));
				cuisineToFoods.get(cuisine).add(food);
			}
		}
		
		public void changeRating(String food, int newRating) {
			String cuisine = foodToCuisine.get(food);
			cuisineToFoods.get(cuisine).remove(food);
			foodToRating.put(food, newRating);
			cuisineToFoods.get(cuisine).add(food);
		}
		
		public String highestRated(String cuisine) {
			return cuisineToFoods.get(cuisine).first();
		}
	}
}
