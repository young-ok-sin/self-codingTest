import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] indegree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList[N+1];
		indegree = new int[N+1];
		
		for(int i = 1 ; i < N+1; i++){
			list[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			int n = sc.nextInt();
			int cur = sc.nextInt();
			for(int j = 0; j < n-1; j++) {
				int next = sc.nextInt();
				
				list[cur].add(next);
				indegree[next]++;
				cur = next;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 1; i < N+1; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			result.add(cur);
			
			for(int i : list[cur]) {
				indegree[i]--;
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		if(result.size() != N) {
			System.out.println(0);
		}
		else {
			for(int i : result) {
				System.out.println(i);
			}
		}
	}
}
