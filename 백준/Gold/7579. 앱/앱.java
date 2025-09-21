import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int memori[] = new int[N+1];
        int weight[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            memori[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 1; i <= N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            sum += weight[i];
        }
        int dp[][] = new int[N+1][sum+1];
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= sum; j++){
                if(j >= weight[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + memori[i]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int j = 0; j <= sum; j++){
            if(dp[N][j] >= M)   {
                result = Math.min(result,j);
            }
        }
        System.out.println(result);
    }
}
