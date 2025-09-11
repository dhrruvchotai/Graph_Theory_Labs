import java.util.ArrayList;
import java.util.HashSet;

public class CheckHallsCondition {
    public static void main(String[] args) {
        Character part1[] = {'a','b','c'};
        int part2[] = {1,2,3};
        int adjMat[][] = {{1,2}, {1,3},{3}};
        boolean isHallsConditionSatisfied = true;
        // Character part1[] = {'a','b'};
        // int part2[] = {1};
        // int adjMat[][] = {{1}, {1}};
        ArrayList<ArrayList<Character>> ansList = new ArrayList<>();
        findAllSubSets(0, part1, new ArrayList<>(), ansList);
        
        for(ArrayList<Character> temp : ansList){
            int sizePart1 = temp.size();
            HashSet<Integer> st = new HashSet<>();

            for(Character ch : temp){
              for(int i = 0; i < adjMat[ch - 97].length; i++){
                st.add(adjMat[ch - 97][i]);
              }
            }

            if(sizePart1 > st.size()){
                isHallsConditionSatisfied = false;
                break;
            }
            
        }

        if(isHallsConditionSatisfied){
            System.out.println("Halls Condition Satisfied!!");
        }
        else{
            System.out.println("Halls Condition Failed!!");
        }
    }

    public static ArrayList<ArrayList<Character>> findAllSubSets(int startIndex, Character arr[], ArrayList<Character> tempList, ArrayList<ArrayList<Character>> ansList){
        ansList.add(new ArrayList<>(tempList));
        for(int i = startIndex; i < arr.length; i++){
            tempList.add(arr[i]);
            findAllSubSets(i+1, arr, tempList, ansList);
            tempList.remove(tempList.size() - 1);
        }
        return ansList;
    }
}
