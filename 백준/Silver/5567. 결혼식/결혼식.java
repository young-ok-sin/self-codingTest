import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,sum;
    static boolean visited[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        bfs();

        System.out.println(sum);

    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.add(new int[]{1,0});

        while(!q.isEmpty()){
            int cur[] = q.poll();

            int person = cur[0];
            int depth = cur[1];

            if(depth >= 2) continue;

            for(int next : list[person]){
                if(!visited[next]){
                    visited[next] = true;
                    sum++;
                    q.add(new int[]{next, depth + 1});
                }
            }
        }
    }
}
