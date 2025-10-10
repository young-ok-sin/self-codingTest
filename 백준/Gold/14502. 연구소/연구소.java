import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, input[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, safe_cnt;
    static class Virus{
        int n,m;
        Virus(int n, int m){
            this.n = n;
            this.m = m;
        }
    }
    static ArrayList<Virus> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        //입력 및 바이러스 구역 저장
        input = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
                if(input[i][j] == 2){
                    list.add(new Virus(i,j));
                }
            }
        }
        dfs(0);
        System.out.println(safe_cnt);
    }
    // 벽 세우기
    static void dfs(int cnt){
        if(cnt == 3){
            bfs();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(input[i][j] == 0){
                    input[i][j] = 1;
                    dfs(cnt + 1);
                    input[i][j] = 0;
                }
            }
        }
    }
    //바이러스 전파
    static void bfs(){
        int[][] temp = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                temp[i][j] = input[i][j];
            }
        }

        Queue<Virus> q = new ArrayDeque<>();
        for(Virus v : list) q.offer(v);

        while (!q.isEmpty()){
            Virus cur = q.poll();
            int cx = cur.n;
            int cy = cur.m;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M ){
                    if(temp[nx][ny] == 0){
                        temp[nx][ny] = 2;
                        q.offer(new Virus(nx,ny));
                    }
                }
            }
        }
        safeArea(temp);
    }
    //안전영역 계산
    static void safeArea(int arr[][]){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0) cnt++;
            }
        }
        safe_cnt = Math.max(safe_cnt,cnt);
    }
}

