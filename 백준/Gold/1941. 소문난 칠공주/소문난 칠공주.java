import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static char[][] arr;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static int cnt = 0;
    static boolean[] selected = new boolean[25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];
        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            for(int j = 0; j < 5; j++){
                arr[i][j] = line.charAt(j);
            }
        }
        combination(0,0);
        System.out.println(cnt);
    }
    static void combination(int depth, int start){
        if(depth == 7){
            if(isValid()) cnt++;
            return;
        }
        for(int i = start; i < 25; i++){
            selected[i] = true;
            combination(depth + 1, i + 1);
            selected[i] = false;
        }
    }
    static boolean isValid(){
        int s_cnt = 0;
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < 25; i++){
            if(selected[i]){
                int x = i / 5;
                int y = i % 5;
                list.add(new int[]{x,y});
                if(arr[x][y] == 'S')    s_cnt++;
            }
        }
        if(s_cnt < 4)   return false;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        q.add(list.get(0));
        visited[list.get(0)[0]][list.get(0)[1]] = true;

        int con_cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)  continue;

                if(!visited[nx][ny] && selected[nx * 5 + ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    con_cnt++;
                }
            }
        }
        return con_cnt == 7;
    }
}
