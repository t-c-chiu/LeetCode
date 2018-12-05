package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
		queueReconstructionByHeight.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
	}

	public int[][] reconstructQueue(int[][] people) {
		List<int[]> result = new ArrayList<>(people.length);
		// [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
		Arrays.sort(people, (o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1];
			else
				return o2[0] - o1[0];
		});
		// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
		for (int[] person : people) {
			result.add(person[1], person);
		}
		return result.toArray(new int[people.length][]);
	}
}
