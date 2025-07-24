public class CreateAdjacenecyMatrix {
    public static void main(String[] args) {
        int totalNodes = 6;
        int nodes[] = { 0, 1, 2, 3, 4, 5 };
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 0, 4 }, { 3, 4 } };
        int adjMatrix[][] = new int[totalNodes][totalNodes];

        for (int i = 0; i < edges.length; i++) {
            adjMatrix[edges[i][0]][edges[i][1]] = 1;
            adjMatrix[edges[i][1]][edges[i][0]] = 1;
        }

        System.out.println("Adjacency Matrix : ");
        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("Isolated Vertices are : ");
        int flag = 1;
        for (int i = 0; i < nodes.length; i++) {
            flag = 1;
            for (int j = 0; j < nodes.length; j++) {
                if (adjMatrix[i][j] == 1) {
                    flag = 0;
                }
            }
            if (flag == 1)
                System.out.print(nodes[i] + " ");
        }
    }
}
