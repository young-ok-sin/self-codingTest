import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, arr[][], dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        int cnt = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cnt++;
            }
        }
        
        int time = 0;
        while(cnt > 0){

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == -1) arr[i][j] = 0;
                }
            }

            outAir();

            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                for(int j = 0 ; j < M; j++){
                    if(arr[i][j] == 1){
                        int airCnt = 0;
                        for(int d = 0; d < 4; d++){
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                                if(arr[nx][ny] == -1)   airCnt++;
                            }
                        }
                        if(airCnt >= 2) list.add(new int[]{i,j});
                    }
                }
            }

            for(int[] pos : list){
                arr[pos[0]][pos[1]] = 0;
                cnt--;
            }
            time++;
        }
        System.out.println(time);
    }

    private static void outAir() {
        visited = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        arr[0][0] = -1;

        while (!q.isEmpty()){
            int cur[] = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && arr[nx][ny] <= 0) {
                        visited[nx][ny] = true;
                        arr[nx][ny] = -1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}

