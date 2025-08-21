import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M; //정점, 간선
	static int[] indegree;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList[N+1];
		indegree = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList();
		}
		int from, to;
		for(int i = 0; i < M; i++) {
			from  = sc.nextInt();
			to = sc.nextInt();
			
			list[from].add(to);
			indegree[to]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
			
		}
		ArrayList<Integer> res = new ArrayList<>();
		
		
		// 큐 사이즈가 0이면 위상정렬 불가
		int idx;
		while(!q.isEmpty()) {
			idx = q.poll();
			res.add(idx);
			for(int cur : list[idx]) {//인접 정점 간선 제거
				indegree[cur]--;
				if(indegree[cur] == 0) {
					q.offer(cur);
				}
			}
		}
		//res.size() == N 
		for(int cur : res) {
			System.out.print(cur + " ");
		}
		System.out.println();
	} 
}
