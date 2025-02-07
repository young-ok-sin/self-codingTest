package Greedy;

import java.io.IOException;
import java.util.Scanner;

/* 숫자 카드 게임
- NxM(행x열) 형태로 놓여있는 카드
- 행을 선택하여 해당 행에서 가장 작은 카드를 뽑음
- 가장 큰 수를 뽑기 위해 전략적으로 접근
 */

public class Ch3_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int min_arr[] = new int[row];
        int arr[][] = new int[row][col];
        int result = 0;

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                arr[i][j] = sc.nextInt();
                if(j==0){
                   min_arr[i] = arr[i][j];
                   // 첫번째 값이 각 행의 min으로 임의 저장
                }
                else{
                    if(min_arr[i] > arr[i][j])
                        min_arr[i] = arr[i][j];
                }
            }
        }
        for(int i=0; i<row; i++){
            result = min_arr[0];
            if(result < min_arr[i]){
                result = min_arr[i];
            }
        }
        System.out.println(result);
    }
}
