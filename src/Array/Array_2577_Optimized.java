package Array;

import java.util.Scanner;

public class Array_2577_Optimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] arr = new int[10];

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a*b*c;

        while( sum != 0 ){
            arr[sum%10]++;
            sum /= 10;
        }

        for(int cnt:arr){
            System.out.println(cnt);
        }
    }

}
