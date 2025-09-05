import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int dp[][][] = new int[N+1][N+1][3];
		int arr[][] = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1; // 원점에서 가로로 가는건 고정이므로 1로 고정
		
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				if(arr[r][c] == 1) continue;
				// 가로
				if(c - 1 >= 1 && arr[r][c - 1] == 0) { //이동할 수 있는 방향 더하기
					dp[r][c][0] += dp[r][c - 1][0];
					dp[r][c][0] += dp[r][c - 1][2];
				}
				// 아래	
				if(r - 1 >= 1 && arr[r - 1][c] == 0) {
					dp[r][c][1] += dp[r - 1][c][1];
					dp[r][c][1] += dp[r - 1][c][2];
				}
				// 대각선
				if(r - 1 >= 1 && c - 1 >= 1 && 
						arr[r - 1][c] == 0 && arr[r][c - 1] == 0 && arr[r - 1][c - 1] == 0) {
					dp[r][c][2] += dp[r - 1][c - 1][0];
					dp[r][c][2] += dp[r - 1][c - 1][1];
					dp[r][c][2] += dp[r - 1][c - 1][2];
				}
			}
		}
		int answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(answer);
	}

}
