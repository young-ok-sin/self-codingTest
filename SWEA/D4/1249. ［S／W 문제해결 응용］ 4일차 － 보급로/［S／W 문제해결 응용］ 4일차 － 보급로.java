import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N = 0, INF = Integer.MAX_VALUE; 
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static class Edge implements Comparable<Edge>{
		int time, x, y;
		Edge(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			//입력
			for(int i = 0; i < N; i++) {
				String line = br.readLine().trim();
				for(int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}
			System.out.println("#" + test_case + " " + dijkstra(0,0));
		}
		
	}
	static int dijkstra(int sx, int sy) {
		int[][] minTime = new int[N][N];
		boolean[][] visited = new boolean [N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		minTime[sx][sy] = 0;
		pq.offer(new Edge(sx, sy, minTime[sx][sy]));
		
		while(!pq.isEmpty()) {
			Edge stopOver = pq.poll();
			
			if(visited[stopOver.x][stopOver.y]) continue;
			visited[stopOver.x][stopOver.y] = true;
			
			if(stopOver.x == N-1 && stopOver.y == N-1) return stopOver.time;
			
			for(int d = 0; d < 4; d++) {
				int nx = stopOver.x + dx[d];
				int ny = stopOver.y + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] 
						&& minTime[nx][ny] > stopOver.time + arr[nx][ny]) {
					minTime[nx][ny] = stopOver.time + arr[nx][ny];
					pq.offer(new Edge(nx, ny, minTime[nx][ny]));
				}
			}
		}
		return -1;
	}
}
