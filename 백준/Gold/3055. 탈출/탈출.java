import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, dist[][], dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static char arr[][];
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> waterQ = new LinkedList<>();
    static Queue<Point> sQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        dist = new int[R][C];

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == '*')    waterQ.add(new Point(i,j));
                else if(arr[i][j] == 'S'){
                    sQ.add(new Point(i,j));
                    dist[i][j] = 1;
                }
            }
        }
        bfs();
    }

    static void bfs(){
        while(!sQ.isEmpty()){
            int size = waterQ.size();
            for(int i = 0; i < size; i++){
                Point p = waterQ.poll();
                for(int d = 0; d < 4; d++){
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                        if(arr[nx][ny] == '.'){
                            arr[nx][ny] = '*';
                            waterQ.add(new Point(nx,ny));
                        }
                    }
                }
            }

            int s_size = sQ.size();
            for(int i = 0; i < s_size; i++){
                Point s = sQ.poll();
                for(int d = 0; d < 4; d++){
                    int nx = s.x + dx[d];
                    int ny = s.y + dy[d];
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                        if(arr[nx][ny] == 'D'){
                            System.out.println(dist[s.x][s.y]);
                            return;
                        }

                        if(arr[nx][ny] == '.'){
                            arr[nx][ny] = 'S';
                            dist[nx][ny] = dist[s.x][s.y] + 1;
                            sQ.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}
