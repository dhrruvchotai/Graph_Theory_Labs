import java.util.ArrayList;

class DepthFirstSearch {
    boolean visited[];
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

    DepthFirstSearch(int total_nodes){
        visited = new boolean[total_nodes];
        for(int i = 0;i<total_nodes;i++){
            adjList.add(new ArrayList<>());
        }
    }

    void addElementsInArrayList(int arr[][]){
        for(int i=0;i<arr.length;i++){
            adjList.get(arr[i][0]).add(arr[i][1]);
            adjList.get(arr[i][1]).add(arr[i][0]);
        }
    }

    void dfs(int start){
        visited[start] = true;
        for(int node : adjList.get(start)){

        }
    }
}

public class DepthFirstSearchDemo {
    public static void main(String[] args) {

    }
}
