package app.src.main.java;
import java.util.LinkedList;
import java.util.List;

public class Sociopath {

	public int findTheSociopath (int groupSize, List<int []> likeList) {
        // create something like topological sorting
        // make arrays of col1 for incoming and col2 for outgoing
        int length = groupSize + 1;
        int[] outGoingCount = new int[length];
        int[] inComingCount = new int[length];

        for(int[] like : likeList){
            int from = like[0];
            int to = like[1];

            if(from > groupSize || to > groupSize || from < 0 || to < 0){
                return -1;
            }

            outGoingCount[from]++;
            inComingCount[to]++;
        }

        for (int i = 1; i <= groupSize; i++) {
            if(outGoingCount[i] == 0 && inComingCount[i] == (groupSize-1)){
                return i;
            }
        }
		return -1;
	}
}
