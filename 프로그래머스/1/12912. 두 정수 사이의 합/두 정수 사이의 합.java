import java.util.*;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        for(; small <= big; small++){
         answer += small;   
        }
        return answer;
    }
}