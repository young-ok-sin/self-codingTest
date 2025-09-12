import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int dp[] = new int[N + 1];
		
		for(int i = 0 ; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			for(int t = N; t >= time; t--) {
				dp[t] = Math.max(dp[t], dp[t-time] + weight);
			}
		}
		System.out.println(dp[N]);
	}

}
