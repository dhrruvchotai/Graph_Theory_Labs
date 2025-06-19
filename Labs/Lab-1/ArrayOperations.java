import java.util.Scanner;

public class ArrayOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n;i++){
            System.out.println("Enter "+i+"th element");
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            System.out.println(i + "th element is : "+arr[i]);
        }

        Array array = new Array();
        System.out.println("Min is : "+array.findMin(n, arr));
        System.out.println("Max is : "+array.findMax(n, arr));
        sc.close();

    }
}

class Array{
    public static int findMin(int n,int arr[]){
        int min = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

     public static int findMax(int n,int arr[]){
        int max = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}