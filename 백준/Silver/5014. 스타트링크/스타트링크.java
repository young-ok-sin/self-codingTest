import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[F+1];
        int dist[] = new int[F+1];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        visited[S] = true;
        dist[S] = 0;

        while (!q.isEmpty()){
            int cur = q.poll();

            if(cur == G){
                System.out.println(dist[cur]);
                return;
            }

            if(cur + U <= F && !visited[cur + U]){
                visited[cur + U] = true;
                dist[cur + U] = dist[cur] + 1;
                q.offer(cur+ U);
            }
            if(cur - D > 0 && !visited[cur - D]){
                visited[cur - D] = true;
                dist[cur - D] = dist[cur] + 1;
                q.offer(cur - D);
            }
        }
        System.out.println("use the stairs");
    }
}
