import java.util.ArrayList;

public class MaxGroups {

    public static void main(String[] args) {
        int adjArr[][] = { { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 1 } };
        boolean visited[] = new boolean[adjArr.length];
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        DFS dfs = new DFS();
        int ans = 0;

        for (int i = 0; i < adjArr.length; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<adjArr.length;i++){
            for(int j=0;j<adjArr[0].length;j++){
                if(adjArr[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);  
                }
            }
        }

        for(int i=0;i<adjList.size();i++){
            if(!visited[i]){
                dfs.deptFirstSearch(adjList, visited, i, ansList);
                ans++;
            }
        }

        System.out.println("Total Groups : "+ans);
    }

}

class DFS {
    void deptFirstSearch(ArrayList<ArrayList<Integer>> adjList, boolean visited[],int s,ArrayList<Integer> ansList){
        visited[s] = true;
        ansList.add(s);

        for(int i: adjList.get(s)){
            if(!visited[i]){
                deptFirstSearch(adjList, visited, i, ansList);
            }
        }

    } 
}
