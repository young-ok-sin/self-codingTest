import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N; 
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int minDiff = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int mask = 1; mask < (1 << N); mask++) {
				int team1 = 0;
				int team2 = 0;
				for(int i = 0; i < N; i++) {
					if((mask & (1<<i)) != 0) {
						for(int j = i + 1; j < N; j++) {
							if((mask & (1 << j)) != 0) {
								team1 += arr[i][j] + arr[j][i];
							}
						}
					}
					else {
						for(int j = i + 1; j < N; j++) {
							if((mask & (1 << j)) == 0) {
								team2 += arr[i][j] + arr[j][i];
							}
						}
					}
				}
				int diff = Math.abs(team1 - team2);
				minDiff = Math.min(diff, minDiff);
			}
			System.out.println("#" + test_case+ " " + minDiff);
		}
	}
}
