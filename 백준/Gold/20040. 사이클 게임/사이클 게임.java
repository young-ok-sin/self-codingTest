import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int parents[];
	static int N, M;
	
	static void make() {
		for(int i = 0 ; i < N; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		else {
			return parents[a] = find(parents[a]);
		}
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N];

		make();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(!union(from,to)) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(0);

	}
	

}
