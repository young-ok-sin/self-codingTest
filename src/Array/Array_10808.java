package Array;

import java.util.Scanner;

public class Array_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int arr[] = new int[26];

        for(int i = 0; i < input.length(); i++){
            char digit = input.charAt(i);
            arr[digit - 'a']++;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
