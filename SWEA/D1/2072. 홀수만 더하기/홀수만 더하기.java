import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                int a = Integer.parseInt(st.nextToken());
                if(a % 2 == 1){
                    list.add(a);
                }
            }
            int sum = 0;
            for(int i = 0; i < list.size(); i++){
                sum += list.get(i);
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}

