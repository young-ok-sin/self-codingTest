import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int x,y,time;
        Pair(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int r, c, alive, total_time= 0;
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[c+1][r+1];
        visited = new boolean[c+1][r+1];

        for(int i = 1; i <= r; i++){
            String line = br.readLine(); 
            for(int j = 1; j <= c; j++){
                arr[j][i] = line.charAt(j-1)-'0';
            }
        }
        //모두 죽을 때까지 몇 초
        st = new StringTokenizer(br.readLine());
        int start_x = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());

        bfs(start_x, start_y, 3);

        // 못죽는거 있나 확인
        for(int i = 1; i <= c; i++){
            for(int j = 1; j <= r; j++){
                if(!visited[i][j] && arr[i][j] == 1)  alive++;  
            }
        }
        System.out.println(total_time);
        System.out.print(alive);
    }

    static void bfs(int x, int y, int time){
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(x,y,time));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            total_time = p.time;
            int cur_x = p.x;
            int cur_y = p.y;

            for(int d = 0; d < 4; d++){
                int next_x = cur_x + dx[d];
                int next_y = cur_y + dy[d];

                if(next_x < 1 || next_y < 1 || next_x > c || next_y > r) continue;
                if(!visited[next_x][next_y] && arr[next_x][next_y] == 1){
                    q.offer(new Pair(next_x, next_y, p.time+1));
                    visited[next_x][next_y] = true;
                }
            }
        }
    }
}
