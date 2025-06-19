import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {

        int arr[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 } };
        Set<Integer> st = new HashSet<>();
        // BreathFirstSearch bfs = new BreathFirstSearch(4);

        for (int i = 0; i < arr.length; i++) {
            st.add(arr[i][0]);
        }
        System.out.println("Edges are : ");
        for (int element : st) {
            System.out.print(element + "->");
            for (int i = 0; i < arr.length; i++) {
                if (element == arr[i][0]) {
                    System.out.print(arr[i][1] + ",");
                    // bfs.addPairInArrayList(arr[i][0], arr[i][1]);
                }
            }
            System.out.println();
        }
        // System.out.println("bfs is : ");
        // bfs.bfs(1);
        inDegeree(arr);
        outDegree(arr);
    }

    public static void inDegeree(int arr[][]) {
        int ans[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ans[arr[i][0]]++;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println("In Degree of " + i + " is : " + ans[i]);
        }
    }

    public static void outDegree(int arr[][]) {
        int ans[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ans[arr[i][0]]++;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println("Out Degree of " + i + " is : " + ans[i]);
        }
    }
}
