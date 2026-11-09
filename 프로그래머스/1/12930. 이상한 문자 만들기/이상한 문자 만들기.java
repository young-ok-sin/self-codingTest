import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 배열에 담기
        String[] arr= s.split(" ",-1);
        //배열 꺼내면서 변환하기
        for(int i = 0; i < arr.length; i++){
            if(i > 0)   sb.append(" ");
            arr[i] = change(arr[i]);
            sb.append(arr[i]);
        }
        answer = sb.toString();
        return answer;
    }
    
    static String change(String input){
        //char 배열로 변환
        char[] arr = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            arr[i] = input.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                arr[i] = Character.toUpperCase(arr[i]);
            }
            else arr[i] = Character.toLowerCase(arr[i]);
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}