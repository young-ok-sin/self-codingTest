import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(a == '('){
                stack.push('(');
            }
            
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    answer = false;
                }
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}