import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, day;
    static int A [][];
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static ArrayList<Points> list = new ArrayList<>();
    static class Points{
        int x, y;
        Points(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            if(!union())break;
            day++;
        }
        System.out.println(day);
    }

    static boolean union(){
        boolean status = false;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        ArrayList<Points> list = new ArrayList<>();
                        int sum = bfs(i,j,list);
                        int size = list.size();
                        if(size > 1){
                            int avg = sum/size;
                            for(Points p : list){
                                A[p.x][p.y] = avg;
                            }
                            status = true;
                    }
                }
            }
        }
        return status;
    }
    static int bfs(int x, int y, ArrayList<Points> union_list){
        Queue<Points> q = new ArrayDeque<>();
        q.offer(new Points(x,y));
        union_list.add(new Points(x,y));
        visited[x][y] = true;
        int sum = A[x][y];

        while (!q.isEmpty()){
            Points p = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N)  continue;
                if(visited[nx][ny]) continue;

                int diff = Math.abs(A[p.x][p.y] - A[nx][ny]);
                if(diff >= L && diff <= R){
                    visited[nx][ny] = true;
                    q.offer(new Points(nx,ny));
                    union_list.add(new Points(nx,ny));
                    sum += A[nx][ny];
                }
            }
        }
        return sum;
    }
}
