import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X, cnt;
    static ArrayList<Integer>[] list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[v].add(u);
        }
        X = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        bfs();
        System.out.println(cnt);
    }
    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);
        visited[X] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : list[cur]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

    }
}
