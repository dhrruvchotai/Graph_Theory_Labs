import java.util.ArrayList;

public class FIndDominantSetOfGraph {
    public static void main(String[] args) {
        int nodes[] = {0,1,2,3};
        int edges[][] = {{0,1},{0,2},{1,3},{2,3}};
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> setList = new ArrayList<ArrayList<Integer>>();
         ArrayList<ArrayList<Integer>> dominantSets = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<edges.length;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        findAllPossibleSets(0, nodes, setList, new ArrayList<>());
        
        for(ArrayList<Integer> setOfNodes : setList){
            boolean isSetDominant = isDominantSet(nodes.length, adjList, setOfNodes);
            if(isSetDominant){
                dominantSets.add(setOfNodes);
            }
        }
        System.out.println(dominantSets);
    }

    public static void findAllPossibleSets(int startIndex,int nodes[],ArrayList<ArrayList<Integer>> setList, ArrayList<Integer> tempList){
        setList.add(new ArrayList<>(tempList));
        for(int i=startIndex;i<nodes.length;i++){
            tempList.add(nodes[i]);
            findAllPossibleSets(i+1, nodes, setList, tempList);
            tempList.remove(tempList.size()-1);
        }
    }

     public static boolean isDominantSet(int totalNodes,ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> setOfNodes){
        boolean coveringNodes[] = new boolean[totalNodes];
        for(int i : setOfNodes){
            for(int j : adjList.get(i)){
                coveringNodes[j] = true;
            }    
        }

        for(int i=0;i<coveringNodes.length;i++){
            if(coveringNodes[i] == false) return false;
        }
        return true;
    }
}
