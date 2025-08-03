package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int result[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[0] >= height){
                    result[i] = stack.peek()[1] + 1;
                    break;
                } else stack.pop();
            }
            if(stack.isEmpty())
                result[i] = 0;
            stack.push(new int[]{height, i});
        }

        for(int i: result){
            System.out.print(i + " ");
        }
    }
}
