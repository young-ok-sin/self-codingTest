import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            int n = Integer.parseInt(br.readLine());

            Point[] points = new Point[n+2];

            for(int i = 0; i < n+2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points[i] = new Point(x,y);
            }

            boolean visited[] = new boolean[n+2];
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(0);
            visited[0] = true;

            boolean isPosible = false;

            while (!q.isEmpty()){
                int now = q.poll();

                if(now == n+1){
                    isPosible = true;
                    break;
                }

                for(int next = 0; next < n+2; next++){
                    if(!visited[next] && distance(points[now], points[next]) <= 1000){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            sb.append(isPosible ? "happy\n" : "sad\n");
        }
        System.out.print(sb);
    }

    static int distance(Point a, Point b){
        int sum = 0;
        sum += Math.abs(a.x - b.x);
        sum += Math.abs(a.y - b.y);
        return sum;
    }
}
