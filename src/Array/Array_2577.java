package Array;

import java.util.Scanner;

public class Array_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a * b * c;

        String ch_sum = String.valueOf(sum);

        for(int i = 0; i < ch_sum.length(); i++){
            char digit = ch_sum.charAt(i);
            arr[digit - '0']++;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
