package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        Stack <Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt(); //n개 입력 받기
        }
        int start = 1;
        for(int i = 0; i < n; i++){
            int target = arr[i];
            while(start <= target){
                stack.push(start);
                sb.append("+\n");
                start++;
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
