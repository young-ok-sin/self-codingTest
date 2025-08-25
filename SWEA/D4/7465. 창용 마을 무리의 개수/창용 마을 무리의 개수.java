import java.util.Scanner;

class Solution {
	static int N,M = 0;
	static int[] parents;
	static boolean[] visited;
	
	private static void make() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N+1];
			visited = new boolean[N+1];
			make();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				union(a,b);
			}
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				int root = find(i);
				
				if(!visited[root]) {
					visited[root] = true;
					cnt++;
				}
			}
			sb.append(cnt);
			System.out.println(sb);
		}
	}
}