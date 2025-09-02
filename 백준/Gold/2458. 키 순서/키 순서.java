import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int parents[];
	static ArrayList<Integer>[] list, rev;
	static boolean visited[];
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			
			list[a].add(b);
			rev[b].add(a);
		}
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int big = bfs(i,list);
			int small = bfs(i, rev);
			
			if(big + small == N-1) ans++;
		}
		System.out.println(ans);
	}
	static int bfs(int start, ArrayList<Integer>[] graph) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : graph[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		return cnt;
		
	}

}
