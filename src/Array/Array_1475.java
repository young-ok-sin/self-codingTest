package Array;

import java.util.Scanner;

public class Array_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int arr[] = new int[10];

        while(input != 0) {
            arr[input % 10]++;
            input = input / 10;
        }
        int set = 0;
        arr[6] = (((arr[6] + arr[9]) / 2) +((arr[6] + arr[9]) % 2));
        arr[9] = 0;

        for(int i : arr) {
            set = Math.max(set,i);
        }
        System.out.println(set);

    }
}

