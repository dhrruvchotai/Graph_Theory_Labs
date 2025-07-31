public class CreateLaplacianMatrix{
    public static void main(String[] args) {
        int totalNodes = 4;
        int edges[][] = { { 0, 2 }, { 0, 3 }, { 2, 3 }, { 1, 3 } };
        int adjMatrix[][] = new int[totalNodes][totalNodes];
        int degreeMatrix[][] = new int[totalNodes][totalNodes];
        int laplacianMatrix[][] = new int[totalNodes][totalNodes];

        for (int i = 0; i < edges.length; i++) {
            adjMatrix[edges[i][0]][edges[i][1]] = 1;
            adjMatrix[edges[i][1]][edges[i][0]] = 1;
        }

    
        for(int i=0;i<degreeMatrix.length;i++){
            int rowSum = 0;
            for(int j=0;j<degreeMatrix.length;j++){
                rowSum += adjMatrix[i][j];
            }
            degreeMatrix[i][i] = rowSum;
        }

        for (int i = 0; i < laplacianMatrix.length; i++) {
            for (int j = 0; j < laplacianMatrix.length; j++) {
                laplacianMatrix[i][i] = degreeMatrix[i][j] = adjMatrix[i][j];
            }
            System.out.println();
        }

        System.out.println("Adjacency Matrix : ");
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(" ");
        System.out.println("Degree Matrix : ");
        for (int i = 0; i < degreeMatrix.length; i++) {
            for (int j = 0; j < degreeMatrix.length; j++) {
                System.out.print(degreeMatrix[i][j] + " ");
            }
            System.out.println();
        }

        
        System.out.println();
        System.out.println("Laplacian Matrix : ");
        for (int i = 0; i < laplacianMatrix.length; i++) {
            for (int j = 0; j < laplacianMatrix.length; j++) {
                System.out.print(laplacianMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
