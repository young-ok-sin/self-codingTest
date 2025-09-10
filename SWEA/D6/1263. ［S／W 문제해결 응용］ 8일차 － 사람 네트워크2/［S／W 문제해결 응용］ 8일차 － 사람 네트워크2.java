import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 99999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int val = Integer.parseInt(st.nextToken());
					if(i == j) arr[i][j] = 0;
					else {
						arr[i][j] = (val == 0) ? INF : 1;
					}
				}
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i == k) continue;
					for(int j = 0; j < N; j++) {
						if(j == k || j == i) continue;
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
			
			int min = INF;
			for(int i = 0; i < N; i++) {
				int sum = 0; 
				for(int j = 0; j < N; j++) {
					sum += arr[i][j];
				}
				min = Math.min(min, sum);
			}
			System.out.println("#" + test_case + " " + min);
		}
	}
}
