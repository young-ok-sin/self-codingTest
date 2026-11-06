import java.util.*;

class Solution {
    public boolean solution(String s) {
        int cnt = s.length();
        
        if(cnt != 4 && cnt != 6) return false;
        for(int i = 0; i < cnt; i++){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) return false;
        }
        return true;
    }
}