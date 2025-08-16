package Backtracking;

import java.util.Scanner;

public class Backtracking_15650 {
    static int n,m;
    static int result[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];

        back(0,1);
    }
    static void back(int depth, int start){
        if(depth == m){
            for(int i = 0; i < m; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i <= n ;i++){
            result[depth] = i;
            back(depth+1, i+1);
        }
    }
}
