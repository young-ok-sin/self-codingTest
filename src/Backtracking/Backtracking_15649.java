package Backtracking;

import java.util.Scanner;

public class Backtracking_15649 {
    static int n,m;
    static boolean [] isVisited;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        isVisited = new boolean[n+1];
        arr = new int[m];

        back(0);
    }
    static void back(int depth){
        if(depth == m){
            for(int a : arr) System.out.print(a + " ");
            System.out.println();
            return;
        }
        for(int i = 1 ; i <= n ; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                arr[depth] = i;
                back(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
