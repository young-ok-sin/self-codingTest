import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B, ret, height;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ret = Integer.MAX_VALUE;
        height = 0;
        for(int h = 0; h <= 256; h++){
            int remove = 0;
            int add = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++) {
                    int diff = arr[i][j] - h;

                    if (diff > 0) remove += diff;
                    else add += -diff;
                }
            }
                    if(remove + B < add)    continue;

                    int time = remove * 2 + add;
                    if(ret > time){
                        height = h;
                        ret = time;
                    } else if (ret == time) {
                        if(height < h)  height = h;
                    }
        }
        System.out.println(ret + " " + height);
    }
}
