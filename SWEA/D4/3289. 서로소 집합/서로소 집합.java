import java.util.Scanner;

class Solution{
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
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N+1];
			make();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			for(int i = 0; i < M; i++) {
				int clac = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(clac == 0) {
					union(a,b);
				}
				else if(clac == 1) {
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}
}