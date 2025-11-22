import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char arr[][];
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean isFound = false;

    static ArrayList<Point> t_list, empty_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        t_list = new ArrayList<>();
        empty_list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = st.nextToken().charAt(0);

                if(arr[i][j] == 'X'){
                    empty_list.add(new Point(i,j));
                } else if (arr[i][j] == 'T') {
                    t_list.add(new Point(i,j));
                }
            }
        }
        dfs(0,0);
        System.out.println(isFound == true ? "YES":"NO");
    }
    static boolean check(){
        for(int i = 0; i < t_list.size(); i++) {
            Point cur = t_list.get(i);
            for(int d = 0; d < 4; d++){
                int nx = cur.x ;
                int ny = cur.y ;

                while (true){
                    nx += dx[d];
                    ny += dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    if(arr[nx][ny] == 'O')  break;
                    if(arr[nx][ny] == 'S')  return false;
                }
            }
        }
        return true;
    }
    static void dfs(int depth, int idx){
        if(isFound) return;

        if(depth == 3){
            if(check()) isFound = true;
            return;
        }

        for(int i = idx; i < empty_list.size(); i++){
            Point p  = empty_list.get(i);
            arr[p.x][p.y] = 'O';
            dfs(depth + 1, i + 1);
            arr[p.x][p.y] = 'X';
        }
    }
}
