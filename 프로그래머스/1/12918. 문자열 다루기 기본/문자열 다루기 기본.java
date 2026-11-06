class Solution {
    public boolean solution(String s) {
        int cnt = 0;

        if(s.length() == 4 || s.length() == 6){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    cnt++;
                }
                else return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}