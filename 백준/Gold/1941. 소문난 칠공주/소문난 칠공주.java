import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static char arr[][] = new char[5][5];
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static int cnt;
    static boolean isSelected[] = new boolean[25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            for(int j = 0; j < 5; j++){
                arr[i][j] = line.charAt(j);
            }
        }
        dfs(0,0);
        System.out.println(cnt);
    }

    static void dfs(int total, int start){
        if(total == 7){
            if (checkVaild()) cnt++;
            return;
        }
        for(int i = start; i < 25; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                dfs(total+1, i+1);
                isSelected[i] = false;
            }
        }
    }

    static boolean checkVaild(){
        int s_cnt = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            if(isSelected[i]){
                int x = i/5;
                int y = i%5;
                list.add(new int[] {x, y});
                if(arr[x][y] == 'S') s_cnt++;
            }
        }
        if(s_cnt < 4)   return  false;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(list.get(0));
        boolean visited[][] = new boolean[5][5];
        visited[list.get(0)[0]][list.get(0)[1]] = true;

        int con_cnt = 1;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)  continue;
                if(!visited[nx][ny] && isSelected[nx * 5 + ny]){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    con_cnt++;
                }
            }
        }
        return con_cnt == 7;
    }
}
