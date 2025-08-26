import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight); 
		}
	}
	
	static int N, M;
	static Edge[] edgeList;
	static int[] parents;
	
	static void make() {
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot > bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		
		return true;	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edgeList = new Edge[M];
		parents = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer sb = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(sb.nextToken());
			int to = Integer.parseInt(sb.nextToken());
			int weight = Integer.parseInt(sb.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList);
		make();
		int result = 0;
		int cnt = 0;
		
		for(Edge edge : edgeList) {
			if (!union(edge.from, edge.to)) continue;
			result += edge.weight;
			if(++cnt == N - 1) break;
		}
		System.out.println(result);
		
		
	}
}
