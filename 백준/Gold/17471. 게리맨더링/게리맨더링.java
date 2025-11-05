import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, min_diff = Integer.MAX_VALUE;
	static int[] people;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		list = new ArrayList[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int con = Integer.parseInt(st.nextToken());
				list[i].add(con);
			}
		}
		
		for(int mask = 1; mask < (1 << N) -1; mask++) {
			ArrayList<Integer> g1 = new ArrayList<>();
			ArrayList<Integer> g2 = new ArrayList<>();
		
			for(int i = 0; i < N; i++) {
				if((mask & (1 << i)) != 0)	g1.add(i+1);
				else	g2.add(i+1);
			}
			
			if(isConnected(g1) && isConnected(g2)) {
				int diff = Math.abs(sum(g1) - sum(g2));
				min_diff = Math.min(diff, min_diff);
			}
		}
		
		System.out.println(min_diff == Integer.MAX_VALUE ? -1 : min_diff);
	}
	static boolean isConnected(ArrayList<Integer> area) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(area.get(0));
		visited[area.get(0)] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : list[cur]) {
				if(!visited[next] && area.contains(next)) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		return cnt == area.size();
	}
	
    static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int city : list) {
            sum += people[city];
        }
        return sum;
    }

}
