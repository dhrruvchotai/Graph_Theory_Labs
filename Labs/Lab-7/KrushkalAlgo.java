import java.util.Arrays;

public class KrushkalAlgo {
    static int totalNodes = 4;
    static int parent[] = new int[totalNodes];
    static int totalWeight = 0;
    static int weightedEdges[][] = {
            {0,2,6},
            {0,1,10},
            {0,3,5},
            {1,3,15},
            {2,3,4}
        };

    static int findParent(int index){
        if(parent[index] == index){
            return index;
        }
        return findParent(parent[index]);
    }

    static void union(int nodeA, int nodeB){
        int parentOfNodeA = findParent(nodeA);
        int parentOfNodeB = findParent(nodeB);
        parent[parentOfNodeA] = parentOfNodeB;
    }
    

    public static void main(String[] args) {
    

        for(int i=0;i<totalNodes;i++){
            parent[i] = i;
        }

        Arrays.sort(weightedEdges, (a,b) -> a[2] - b[2]);

        for(int i=0;i<weightedEdges.length;i++){
            int edge[] = new int[2];
            edge = weightedEdges[i];
            if(findParent(edge[0]) != findParent(edge[1])){
                System.out.println(edge[0] + " -> " + edge[1] + " Weight : " + edge[2]);
                totalWeight += edge[2];
                union(edge[0], edge[1]);
            } 
        }
        System.out.println("Total Weight is : "+ totalWeight);
    }
}
