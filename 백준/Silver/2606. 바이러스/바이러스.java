import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static boolean visited[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }
        bfs(1);
        System.out.println(cnt);

    }
    static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            for(int next : list[now]){
                if(!visited[next])  {
                    visited[next] = true;
                    q.offer(next);
                    cnt++;
                }
            }
        }
    }
}
