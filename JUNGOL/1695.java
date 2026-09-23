import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int n;
    static int dx[] = {-1,1,0,0}; 
    static int dy[] = {0,0,-1,1}; 
    static ArrayList<Integer> counts = new ArrayList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    int count = bfs(i, j);
                    counts.add(count);
                }
            }
        }

        Collections.sort(counts);

        System.out.println(counts.size());
        for (int count : counts) {
            System.out.println(count); 
        }
    }

    static int bfs(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{startX,startY});
        visited[startX][startY] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
                }

                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cnt++;
                }
            }
            
        }
        return cnt;
    }
}
