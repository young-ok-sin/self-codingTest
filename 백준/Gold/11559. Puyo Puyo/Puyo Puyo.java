import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static int ret;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        for(int i = 0; i < 12; i++){
            String line = br.readLine();
            for(int j = 0; j < 6; j++){
                arr[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[12][6];
        while (true){
            visited = new boolean[12][6];
            boolean check = false;

            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(!visited[i][j] && arr[i][j] != '.'){
                        List<int[]> g = bfs(i,j);

                        if(g.size() >= 4){
                            check = true;
                            for(int[] p : g){
                                arr[p[0]][p[1]] = '.';
                            }
                        }
                    }
                }
            }
            if(!check)  break;

            gravity();
            ret++;
        }
        System.out.println(ret);
    }
    static List<int[]> bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        visited[x][y] = true;
        q.offer(new int[]{x,y});
        list.add(new int[]{x,y});

        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if(visited[nx][ny]) continue;
                if(arr[x][y] != arr[nx][ny])    continue;

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                list.add(new int[]{nx, ny});
            }
        }
        return list;
    }

    static void gravity(){
        for(int j = 0; j < 6; j++){
            int write = 11;
            for(int i = 11; i >= 0; i--){
                if(arr[i][j] != '.'){
                    char tmp = arr[i][j];
                    arr[i][j] = '.';
                    arr[write][j] = tmp;
                    write--;
                }
            }
        }
    }
}
