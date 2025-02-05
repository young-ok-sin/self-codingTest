package Greedy;

import java.io.IOException;
import java.util.Scanner;

/* 큰 수의 법칙
- 크기가 N인 배열의 수들을 M번 더하여 가장 큰 수를 만드는 법칙
- 특정 인덱스의 수가 연속 K번 초과 불가능
*/
public class Ch3_1 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        int max = 0;
        int max2 = 0;

        for(int i=0; i < n;i++){
            arr[i] = sc.nextInt();
            if(i==0)
            {
                max = arr[0];
                max2 = arr[0];
            }
            if (max < arr[i])
            {
                if (max2 < max)
                    max2 = max;
                max = arr[i];
            }
        }
        int num = (k*(m/(k+1)))+(m%(k+1)); //max의 횟수
        int sum = ((m-num)*max2)+(num*max);
        System.out.print(sum);
    }

}
