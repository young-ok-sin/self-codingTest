import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, cnt;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j)- '0';
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {
				if(visited[i][j] == false && arr[i][j] == 1) {
					int size = dfs(i,j);
					result.add(size);
					cnt++;
				}
			}
		}
		Collections.sort(result);
		System.out.println(cnt);
		
		for(int i : result) {
			System.out.println(i);
		}
	}
	
	static int dfs(int x, int y) {
		visited[x][y] = true;
		int size = 1;
		
		for(int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx >= 0 && cy >= 0 && cx < N && cy < N) {
				if(arr[cx][cy] == 1 && !visited[cx][cy]) {
					size += dfs(cx,cy);
				}
			}
		}
		return size;
	}
}
