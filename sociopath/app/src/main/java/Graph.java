package app.src.main.java;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private LinkedList<Integer>[] adjList; // since we know the size of the group we can
                                          // have it of fixed size
    private int size;

    public Graph(int size) {
        this.size = size;
        this.adjList = new LinkedList[size]; // why is this giving warning ?
    }

    public void createAdjList(List<int []> likeList){
        // like[0] -> from
        // like[1] -> to
        for (int[] like : likeList) {
            adjList[like[0]].add(like[1]);
        }
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    public void printAdjList(){
        for (int i = 0; i < size; i++) {
            System.out.print(i + "-> ");
            for (Integer vertex : adjList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
