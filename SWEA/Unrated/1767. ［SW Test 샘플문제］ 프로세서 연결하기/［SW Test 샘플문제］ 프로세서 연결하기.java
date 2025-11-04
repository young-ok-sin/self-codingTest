import java.io.*;
import java.util.*;

public class Solution {
    static int N, arr[][], maxCore, minLength;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            points.clear();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1 && i > 0 && j > 0 && i < N - 1 && j < N - 1) {
                        points.add(new Point(i, j));
                    }
                }
            }

            maxCore = 0;
            minLength = Integer.MAX_VALUE;
            backtrack(0, 0, 0);
            System.out.println("#" + tc + " " + minLength);
        }
    }

    static void backtrack(int idx, int coreCnt, int wireLen) {
        if (idx == points.size()) {
            if (coreCnt > maxCore) {
                maxCore = coreCnt;
                minLength = wireLen;
            } else if (coreCnt == maxCore) {
                minLength = Math.min(minLength, wireLen);
            }
            return;
        }

        Point p = points.get(idx);
        int x = p.x, y = p.y;

        for(int dir = 0; dir < 4; dir++){
            int cnt = 0, nx = x, ny = y;
            while(true){
                nx += dx[dir];
                ny += dy[dir];

                if(ny < 0 || nx < 0 || nx >= N || ny >= N)  break;

                if(arr[nx][ny] == 1){
                    cnt = 0;
                    break;
                }
                cnt++;
            }

            int fill_x = x;
            int fill_y = y;

            for(int i = 0; i < cnt; i++){
                fill_x += dx[dir];
                fill_y += dy[dir];
                arr[fill_x][fill_y] = 1;
            }

            if(cnt == 0){
                backtrack(idx + 1, coreCnt, wireLen);
            }
            else {
                backtrack(idx + 1, coreCnt + 1, wireLen + cnt);
                fill_x = x;
                fill_y = y;

                for(int i=0; i<cnt; i++) {
                    fill_x += dx[dir];
                    fill_y += dy[dir];
                    arr[fill_x][fill_y] = 0;
                }
            }
        }
    }
}
