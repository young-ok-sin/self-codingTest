import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int dp[][] = new int[N+1][L+1];

            int score[] = new int[N+1];
            int calc[] = new int[N+1];

            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                score[i] = Integer.parseInt(st.nextToken());
                calc[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++){
                for(int j = 0; j <= L; j++){
                    dp[i][j] = dp[i-1][j];
                    if (j >= calc[i])    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - calc[i]] + score[i]);
                }
            }
            System.out.println("#" + test_case + " " + dp[N][L]);

        }
    }
}
