import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,map[][];
    static int dc[] = {0,0,-1,1};
    static int dr[] = {-1,1,0,0};
    static class Node{
        int r, c, broken, dist;
        Node(int r, int c, int broken, int dist){
            this.r = r;
            this.c = c;
            this.broken = broken;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.add(new Node(0,0,0,1));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.r == N-1 && cur.c == M-1)    return cur.dist;

            for(int i = 0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nc < 0 || nc >= M || nr >= N) continue;
                // 다음 칸이 빈칸
                if(map[nr][nc] == 0 && !visited[nr][nc][cur.broken]){
                    visited[nr][nc][cur.broken] = true;
                    q.add(new Node(nr,nc,cur.broken,cur.dist + 1));
                }
                // 다음 칸이 벽
                if(map[nr][nc] == 1 && cur.broken == 0 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    q.add(new Node(nr, nc, 1, cur.dist + 1));
                }
            }
        }
        return -1;
    }

}
