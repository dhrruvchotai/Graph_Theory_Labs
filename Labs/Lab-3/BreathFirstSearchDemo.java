import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BreathFirstSearch {

    Queue<Integer> q = new LinkedList<>();
    ArrayList<ArrayList<Integer>> adjLst = new ArrayList<ArrayList<Integer>>();
    boolean visited[];

    BreathFirstSearch(int total_nodes) {
        visited = new boolean[total_nodes + 1];
        for (int i = 0; i <= total_nodes; i++) {
            adjLst.add(new ArrayList<>());
        }
    }

    // while getting input from other file
    void addPairInArrayList(int u, int v) {
        adjLst.get(u).add(v);
        adjLst.get(v).add(u);
    }

    void addElementsInArrayList(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            adjLst.get(arr[i][0]).add(arr[i][1]);
            adjLst.get(arr[i][1]).add(arr[i][0]);
        }
        System.err.println("ArrayList : " + adjLst);
    }

    void bfs(int first) {
        q.add(first);
        visited[first] = true;

        while (!q.isEmpty()) {
            int element = q.poll();

            System.out.println(element + " ");

            for (int neighbour : adjLst.get(element)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }
}

public class BreathFirstSearchDemo {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 } };
        BreathFirstSearch obj = new BreathFirstSearch(4);
        obj.addElementsInArrayList(arr);
        obj.bfs(1);
    }
}
