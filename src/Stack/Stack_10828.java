package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack <Integer>stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String input = br.readLine();

            if(input.startsWith("push")) {
                int a = Integer.parseInt(input.split(" ")[1]);
                stack.push(a);
            }
            else if(input.equals("pop")) {
                if(stack.size() == 0) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(stack.pop());
                }
            }
            else if(input.equals("size")) {
                System.out.println(stack.size());
            }
            else if(input.equals("empty")) {
                System.out.println(stack.isEmpty()? 1:0);
            }
            else if(input.equals("top")) {
                if(stack.size() == 0) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(stack.peek());
                }
            }
        }
    }

}
