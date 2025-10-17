
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][];
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean selected[];
    static int min_distance = Integer.MAX_VALUE;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)  houses.add(new Point(i,j));
                else if(arr[i][j] == 2) chickens.add(new Point(i,j));
            }
        }
        selected = new boolean[chickens.size()];
        combination(0,0);

        System.out.println(min_distance);
    }

    static void combination(int idx, int cnt){
        if(cnt == M){
            min_distance = Math.min(min_distance, clacDistance());
            return;
        }
        if(idx == chickens.size()) return;

        selected[idx] = true;
        combination(idx + 1, cnt + 1);

        selected[idx] = false;
        combination(idx + 1, cnt);

    }

    static int clacDistance(){
        int total = 0;
        for(Point house : houses){
            int dist = Integer.MAX_VALUE;
            for(int i = 0; i < chickens.size(); i++){
                if(selected[i]){
                    Point chicken = chickens.get(i);
                    dist = Math.min(dist, distance(house,chicken));
                }
            }
            total += dist;
        }
        return total;
    }

    static int distance(Point p1, Point p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
