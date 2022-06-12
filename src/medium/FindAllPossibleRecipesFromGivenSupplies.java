package medium;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {
	
	public static void main(String[] args) {
		List<String> res = findAllRecipes(new String[]{"bread", "sandwich", "burger"},
				Arrays.asList(
						Arrays.asList("yeast", "flour"),
						Arrays.asList("bread", "meat"),
						Arrays.asList("sandwich", "meat", "bread")
				),
				new String[]{"yeast", "flour", "meat"});
		System.out.println(res);
	}
	
	public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		int n = recipes.length;
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> inDegree = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (String ingredient : ingredients.get(i)) {
				map.putIfAbsent(ingredient, new ArrayList<>());
				map.get(ingredient).add(recipes[i]);
			}
			inDegree.put(recipes[i], ingredients.get(i).size());
		}
		List<String> res = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		for (String supply : supplies) {
			queue.offer(supply);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String ingredient = queue.poll();
				if (!map.containsKey(ingredient)) {
					continue;
				}
				for (String recipe : map.get(ingredient)) {
					inDegree.put(recipe, inDegree.get(recipe) - 1);
					if (inDegree.get(recipe) == 0) {
						res.add(recipe);
						queue.offer(recipe);
					}
				}
				map.remove(ingredient);
			}
		}
		return res;
	}
}
