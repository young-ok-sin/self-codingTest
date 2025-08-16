package Recursion;

import java.util.Scanner;

public class Recursion_1629 {
    static long c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();
        System.out.println(multiplication(a,b));
    }
    static long multiplication(long a, long b){
        if(b==1) return a % c;
        long half = multiplication(a,b/2);
        if(b % 2 == 0){
            return (half * half) % c;
        }else return ((half * half) % c * a) % c;
    }

}
