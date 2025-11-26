import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static int arr[][];
    static class Node{
        int x, y, broken,dist;
        Node(int x, int y, int broken, int dist){
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<Node> q = new ArrayDeque();
        boolean visited[][][] = new boolean[N][M][2];
        q.offer(new Node(0,0,0,1));
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            Node n = q.poll();

            if(n.x == N-1 && n.y == M-1)    return n.dist;

            for(int d = 0; d < 4; d++){
                int nx = n.x + dx[d];
                int ny = n.y + dy[d];
                if(nx < 0 || ny < 0 || ny >= M || nx >= N) continue;

                if(arr[nx][ny] == 0 && !visited[nx][ny][n.broken]){
                    visited[nx][ny][n.broken] = true;
                    q.offer(new Node(nx,ny,n.broken,n.dist+1));
                }
                if(arr[nx][ny] == 1 && n.broken == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx,ny,1,n.dist+1));
                }
            }
        }
        return -1;
    }
}
