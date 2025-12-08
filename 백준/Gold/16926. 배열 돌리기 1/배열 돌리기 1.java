import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 너무 어렵다.. 
    static int N, M, R;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(){
        int layers = Math.min(N, M) / 2;

        for(int layer = 0; layer < layers; layer++){
            List<Integer> list = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = N - 1 - layer;
            int right = M - 1 - layer;

            for(int j = left; j <= right; j++)  list.add(arr[top][j]);
            for(int i = top + 1; i <= bottom; i++)  list.add(arr[i][right]);
            for(int j = right - 1; j >= left; j--)  list.add(arr[bottom][j]);
            for(int i = bottom - 1; i > top ; i--)  list.add(arr[i][left]);

            int len = list.size();
            int rot = R % len;

            int idx = rot;

            for(int j = left; j <= right; j++)  arr[top][j] = list.get(idx++ % len);
            for(int i = top + 1; i <= bottom; i++) arr[i][right] = list.get(idx++ % len);
            for(int j = right - 1; j >= left; j--) arr[bottom][j] = list.get(idx++ % len);
            for (int i = bottom - 1; i > top; i--) arr[i][left] = list.get(idx++ % len);
        }
    }
}