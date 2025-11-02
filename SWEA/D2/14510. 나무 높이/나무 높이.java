import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int max_height = 0, N, day;
    static int[] gap, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            max_height = 0;
            day = 0;

            N = Integer.parseInt(br.readLine());

            tree = new int[N];
            gap = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                tree[i] = Integer.parseInt(st.nextToken());
                if(max_height < tree[i])    max_height = tree[i];
            }
            int one_cnt = 0;
            int two_cnt = 0;
            for (int i = 0; i < N; i++) {
                gap[i] = max_height - tree[i];
                
                if(gap[i] == 0) continue;
                
                two_cnt += gap[i] / 2;
                one_cnt += gap[i] % 2;
            }

            if(two_cnt > one_cnt){
                while (Math.abs(two_cnt - one_cnt) > 1) {
                    two_cnt--;
                    one_cnt += 2;
                }
            }

            if(one_cnt > two_cnt){
                day = one_cnt * 2 - 1;
            }
            else if(two_cnt > one_cnt){
                day = two_cnt * 2;
            }
            else {
                day = two_cnt + one_cnt;
            }
            System.out.println("#" + test_case + " "+ day);
        }
    }
}
