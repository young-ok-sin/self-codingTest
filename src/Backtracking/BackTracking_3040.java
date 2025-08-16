package Backtracking;

import java.util.Scanner;

public class BackTracking_3040 {
    static boolean isFound;
    static int arr[] = new int[9];
    static int result[] = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9 ; i++){
            arr[i] = sc.nextInt();
        }
        back(0,0,0);
    }
    static void back(int depth, int start, int sum){
        if(isFound) return;

        if(depth == 7){
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
                isFound = true;
            }
            return;
        }
        for(int i = start; i < 9; i++){
            result[depth] = arr[i];
            back(depth+1, i+1, sum+arr[i]);
        }

    }
}
