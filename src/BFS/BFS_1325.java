package BFS;

import java.io.*;
import java.util.*;

public class BFS_1325 {
    static int n,m;
    static ArrayList<Integer>[] arr;
    static int[] hackCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        hackCnt = new int[n+1];

        for(int i = 1; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[v].add(u);
        }
        int max = 0;

        for(int i = 1; i <= n; i++){
            boolean[] isVisited = new boolean[n+1];
            hackCnt[i] = bfs(i,isVisited);
            max = Math.max(max,hackCnt[i]);
        }

        for(int i =1; i <=n; i++){
            if(hackCnt[i] == max){
                bw.write(i + " ");
            }
        }
        bw.close();
    }
    static int bfs (int start, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : arr[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    q.add(next);
                }
            }
        }
        return count;
    }
}
