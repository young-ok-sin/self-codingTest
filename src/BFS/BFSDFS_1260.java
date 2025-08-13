package BFS;

import java.util.*;

public class BFSDFS_1260 {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(w);
            graph[w].add(u);
        }

        for(int i = 1; i <= n; i++){ //오름차순 출력을 위한 정렬
            Collections.sort(graph[i]);
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        visited = new boolean[n+1];
        bfs(v);
    }
    static void dfs(int i){
        visited[i] = true;
        System.out.print(i + " ");

        for(int next:graph[i]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
    static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");

            for(int next:graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
