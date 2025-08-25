import java.util.Scanner;

class Solution {
	static int N,M = 0;
	static int[] parents;
	
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			parents = new int[N+1];
			make();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st1.nextToken());
				int b = Integer.valueOf(st1.nextToken());
				
				union(a,b);
			}
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(parents[i] == i) {
					cnt++;
				}
			}
			sb.append(cnt);
			System.out.println(sb);
		}
	}
}