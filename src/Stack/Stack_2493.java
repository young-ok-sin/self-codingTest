package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack_2493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<int[]> stack = new Stack<>();
        int n = sc.nextInt();
        int arr[] = new int[n];
        int result[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            while(!stack.isEmpty()){
                if(stack.peek()[0] >= arr[i]){
                    result[i] = stack.peek()[1] + 1;
                    break;
                } else stack.pop();
            }

            stack.push(new int[]{arr[i], i});
        }

        for(int i: result){
            System.out.print(i + " ");
        }
    }
}
