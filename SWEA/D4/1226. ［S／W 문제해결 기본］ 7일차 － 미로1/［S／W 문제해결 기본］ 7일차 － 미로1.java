import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int arr[][], N = 16;
    static boolean visited[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static Node start, end;
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++){
            int T = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                String line = br.readLine().trim();
                for(int j = 0; j < 16; j++){
                    arr[i][j] = line.charAt(j) - '0';
                    if(arr[i][j] == 2) start = new Node(i,j);
                    if(arr[i][j] == 3) end = new Node(i,j);
                }
            }
            System.out.println("#" + test_case + " " + BFS());

        }
    }
    static int BFS(){
        Queue<Node> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.offer(start);

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == end.x && cur.y == end.y) return 1;

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16) continue;
                if(arr[nx][ny] == 1) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx,ny));
            }
        }
        return 0;

    }
}
