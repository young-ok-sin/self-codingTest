package Algo_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonthlyTest_0811_3v1 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){ // 연결된 모든 노드 양방향 추가
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n+1];
        int group_n = 0;


        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                bfs(i);
                group_n++;
            }
        }
        System.out.println(group_n);
    }
    static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
