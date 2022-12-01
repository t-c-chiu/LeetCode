package medium;

import java.util.*;

public class MostPopularVideoCreator {
	
	public static void main(String[] args) {
		List<List<String>> res = mostPopularCreator(
				new String[]{"alice", "bob", "alice", "chris"},
				new String[]{"one", "two", "three", "four"},
				new int[]{5, 10, 5, 4});
		System.out.println(res);
	}
	
	public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
		int n = creators.length;
		Map<String, Integer> creatorToViews = new HashMap<>();
		Map<String, Map<String, Integer>> creatorToVideos = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String creator = creators[i];
			creatorToViews.put(creator, creatorToViews.getOrDefault(creator, 0) + views[i]);
			creatorToVideos.putIfAbsent(creator, new HashMap<>());
			creatorToVideos.get(creator).put(ids[i], views[i]);
		}
		List<String> mostPopularCreators = new ArrayList<>();
		int max = -1;
		for (String creator : creatorToViews.keySet()) {
			int view = creatorToViews.get(creator);
			if (view >= max) {
				if (view > max) {
					max = view;
					mostPopularCreators = new ArrayList<>();
				}
				mostPopularCreators.add(creator);
			}
		}
		List<List<String>> res = new ArrayList<>();
		for (String creator : mostPopularCreators) {
			Map<String, Integer> videoToViews = creatorToVideos.get(creator);
			max = -1;
			String maxVideo = "";
			for (String video : videoToViews.keySet()) {
				int view = videoToViews.get(video);
				if (view > max || view == max && video.compareTo(maxVideo) < 0) {
					max = view;
					maxVideo = video;
				}
			}
			res.add(Arrays.asList(creator, maxVideo));
		}
		return res;
	}
	
}
