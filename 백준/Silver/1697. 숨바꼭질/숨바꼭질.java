import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, min_time = Integer.MIN_VALUE;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N,0});
        visited[N] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int pos = now[0];
            int time = now[1];

            if(pos == K){
                return time;
            }
            int[] next = {pos-1, pos +1, pos * 2 };
            for(int n : next){
                if(n >= 0 && n <= 100000 && !visited[n]){
                    visited[n] = true;
                    q.add(new int[]{n,time + 1});
                }
            }
        }
        return -1;
    }
}
