import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int N, len;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1); // 자기 자신만으로 길이 1
        }
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int x = 0; x <= i; x++) {
					for(int y = 0; y <= j; y++) {
						if((x != i || y != j) && arr[x][y] < arr[i][j]) {
							dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
						}
					}
				}
			}
		}
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dp[i][j]);
           }
        }
        System.out.println(answer);
	}
}
