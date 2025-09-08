import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int used[], restart[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 목표 : 합 >= M
		used = new int[N+1];
		restart = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			used[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			restart[i] = Integer.parseInt(st.nextToken());
			sum += restart[i];
		}
		
		int[][] results = new int[N+1][sum+1];
		for(int i = 1; i <= N; i++) {
			for(int c = 0; c <= sum; c++) {
				if(c >= restart[i]) { // 비용 여유
					results[i][c] = Math.max(results[i-1][c], results[i-1][c - restart[i]] + used[i]); //선택 x, 선택 o
				}
				else { // 비용 부족
					results[i][c] = results[i-1][c];
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int c = 0; c <= sum; c++) {
			if(results[N][c] >= M ) {
				ans = Math.min(ans, c);
			}
		}
		System.out.println(ans);
	}

}
