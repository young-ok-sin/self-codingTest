package SWEA;

import java.util.Scanner;

/*
1206.[S/W 문제해결 기본] 1일차 - View
어려웠던 부분
: Math를 사용하지 않고 문제를 풀려고 하니 코드가 너무 길어졌다.
: c,d가 같은 경우를 처리하지 않아서 Fail 되었었다.
 */
public class D3_1206 {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int result[] = new int[10];
        while(i < 10){
            int num = sc.nextInt();
            int arr[] = new int[num];
            int case_result = 0;

            for(int k = 0; k<num; k++){
                arr[k] = sc.nextInt();
            }
            for(int n = 2 ; n < num-2 ; n++){
                int a = arr[n] - arr[n+1];
                int b = arr[n] - arr[n-1];
                if(a > 0 && b > 0){ //좌우 거리가 1일때 계산
                    int min = 0;

                    if (a>b) min = b;
                    else min = a;

                    int c = arr[n] - arr[n+2];
                    int d = arr[n] - arr[n-2];
                    if(c > 0 && d > 0){
                        min = Math.min(min,Math.min(c,d));

                        case_result += min;
                    }
                }
                result[i] = case_result;
            }
            i++;
        }
        for(int j = 1; j < result.length+1 ; j++){
            System.out.println("#" + j + " " + result[j-1]);
        }
    }
}
