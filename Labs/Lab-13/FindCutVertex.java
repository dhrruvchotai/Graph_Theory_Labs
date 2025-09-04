class FindCutVertex{
    public static void main(String[] args) {
        // int adjArr[][] = {{1,2},{0},{0,3,4,},{2},{2}};
        int adjArr[][] = {{1},{0,2,3},{1,3},{2,1}};
        int n = 4;
        boolean visited[];
        int element = 0;

       while(element <= n-2){
            visited = new boolean[n];
            visited[element] = true;
            for(int i = 0; i < adjArr.length; i++){
                if(i == element){
                    continue;
                }
                for(int j = 0; j < adjArr[i].length; j++){
                    visited[adjArr[i][j]] = true;
                }
            }
            for(int k = 0; k < visited.length; k++){
                // System.out.println(visited[k]);
                if(visited[k] == false){
                    System.out.println(element+ " is cut vertex.");
                    break;
                }
            }
            element++;
       }
    }
}