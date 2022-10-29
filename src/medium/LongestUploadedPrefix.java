package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestUploadedPrefix {
	
	public static void main(String[] args) {
		LUPrefix server = new LUPrefix(4);   // Initialize a stream of 4 videos.
		server.upload(3);                    // Upload video 3.
		System.out.println(server.longest());                    // Since video 1 has not been uploaded yet, there is no prefix.
		// So, we return 0.
		server.upload(1);                    // Upload video 1.
		System.out.println(server.longest());                    // The prefix [1] is the longest uploaded prefix, so we return 1.
		server.upload(2);                    // Upload video 2.
		System.out.println(server.longest());                    // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
	}
	
	static class LUPrefix {
		
		int longest;
		int n;
		Set<Integer> uploaded;
		
		public LUPrefix(int n) {
			longest = 0;
			this.n = n;
			uploaded = new HashSet<>();
		}
		
		public void upload(int video) {
			uploaded.add(video);
			while (uploaded.contains(longest + 1)) {
				longest++;
			}
		}
		
		public int longest() {
			return longest;
		}
	}
}
