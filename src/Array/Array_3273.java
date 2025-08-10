package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();

        Arrays.sort(arr);
        int start_idx = 0;
        int end_idx = n-1;
        int sets = 0;

        while (start_idx < end_idx){
            int cur_sum = arr[start_idx] + arr[end_idx];
            if(arr[start_idx] + arr[end_idx] == sum){
                sets++;
                start_idx++;
                end_idx--;
            }
            else if(cur_sum < sum){
                start_idx++;
            }
            else{
                end_idx--;
            }
        }
        System.out.println(sets);
    }
}
