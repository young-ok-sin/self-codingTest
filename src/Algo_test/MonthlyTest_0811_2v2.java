package Algo_test;

import java.util.Scanner;

public class MonthlyTest_0811_2v2 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int temp[][] = new int[n][n];
        int sum[] = new int[n];
        for (int i = 0; i < n; i++) { //오른쪽 90도 회전
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[n - j - 1][i];
                if(temp[i][j] == 1) {
                	sum[j]++;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int cnt = sum[j];
            for(int i = n-1; i >= 0 ; i--) {
            	if(cnt > 0) {
            		cnt--;
            		temp[i][j] = 1;
            	}else {
            		temp[i][j] = 0;
            	}
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }

	}

}
