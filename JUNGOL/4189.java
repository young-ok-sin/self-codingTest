import java.util.*;
import java.io.*;

public class 4189{
    static int N,M,R,C,S,K;
    static int dx[] = {-2,-2,-1,-1,1,1,2,2}, dy[] = {-1,1,-2,2,-2,2,-1,1};
    static boolean[][] arr; // visited 배열

    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1][M+1];

        st =  new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
    static int bfs(){
        q.offer(new int[] {R,C,0});
        arr[R][C] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if(cx == S && cy == K)  return cnt;

            for(int i = 0; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || ny < 1 || nx > N || ny > M)  continue;
                if(arr[nx][ny]) continue;

                arr[nx][ny] = true;
                q.offer(new int[] {nx,ny,cnt+1});
            }
        }
        return -1;
    }
}
