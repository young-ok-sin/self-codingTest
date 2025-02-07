package Greedy;

import java.util.Scanner;

/* 1이 될 때까지
- 어떤 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
- 단, 2번 연산읜 N이 K로 나누어떨어질 때만 사용할 수 있다.
1. N에서 1을 뺀다.
2. N을 K로 나눈다.
 */
public class Ch3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum=0;
        while(n!=1) {
            if(n % k != 0) {
                n--;
                sum++;
            }
            else {
                n = n / k;
                sum++;
            }
        }
        System.out.println(sum);
    }
}
