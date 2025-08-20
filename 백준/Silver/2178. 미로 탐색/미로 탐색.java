import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[][] dist;
	static boolean[][] visited;
	static int n,m;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		dist = new int[n][m];
		
		for(int i = 0; i < n; i ++) {
			String line = sc.next();
			for(int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(dist[n-1][m-1]);
		
		
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new int[]{x,y});
		dist[x][y] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx >= 0 && ny >= 0 && ny < m && nx < n) {
					if(!visited[nx][ny] && arr[nx][ny] == 1) {
						dist[nx][ny] = dist[cx][cy] + 1;
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}
	

}
