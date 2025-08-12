package Algo_test;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MonthlyTest_0811_2v1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int temp[][] = new int[n][n];

        for (int i = 0; i < n; i++) { //오른쪽 90도 회전
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[n - j - 1][i];
            }
        }

        for (int j = 0; j < n; j++) {
            int end_idx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (temp[i][j] == 1) {
                    temp[i][j] = 0;
                    temp[end_idx][j] = 1;
                    end_idx--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }


    }

}


