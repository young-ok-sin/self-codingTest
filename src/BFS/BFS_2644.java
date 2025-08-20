package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2644 {
    static int n,m;
    static boolean[] visited;
    static int a,b;
    static ArrayList<Integer>[] graph;
    static int dist[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        dist = new int[n+1];

        for(int i = 0; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }
        bfs(a);

        if(!visited[b]){
            System.out.println(-1);
        }
        else{
            System.out.println(dist[b]);
        }
    }


    static void bfs(int i){
        Queue<Integer> q = new ArrayDeque<>();
        visited[i] = true;
        //dist[i] = 0;
        q.offer(i);


        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next]= true;
                    dist[next] = dist[cur]+1;
                    q.offer(next);
                }
            }
        }
    }
}
