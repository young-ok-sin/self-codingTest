import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, arr[][], cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				cnt = 0;
				boolean visited[] = new boolean[N+1];
				gtDFS(i, visited);
				ltDFS(i, visited);
				if(cnt == N-1) ++ans;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}

	}
	
	static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && arr[cur][i] == 1) {
				++cnt;
				gtDFS(i, visited);
			}
		}
	}
	
	static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && arr[i][cur] == 1) {
				++cnt;
				ltDFS(i, visited);
			}
		}
	}
}
