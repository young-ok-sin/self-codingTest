package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++){
            int input = Integer.valueOf(br.readLine());

            if(input == 0){
                stack.pop();
            }
            else{
                stack.push(input);
            }
        }
        while(stack.size() != 0){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
