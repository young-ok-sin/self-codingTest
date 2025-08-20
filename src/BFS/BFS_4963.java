package BFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS_4963 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int w,h;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) break;

            visited = new boolean[h][w];
            arr = new int[h][w];

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }


    }
    static void bfs(int x,int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(!visited[nx][ny] && arr[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
