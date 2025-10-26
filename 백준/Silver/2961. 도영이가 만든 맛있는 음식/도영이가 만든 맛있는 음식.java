import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 신맛은 곱, 쓴맛은 합
        // 둘의 차이를 가장 작게

        int minDiff = Integer.MAX_VALUE;
        for(int mask = 1; mask < (1 << N); mask++){
            int sum = 0;
            int multi = 1;
            for(int i = 0; i < N; i++){
                if((mask & (1 << i)) != 0){
                    multi *= arr[i][0];
                    sum += arr[i][1];
                }
            }
            minDiff = Math.min(minDiff, Math.abs(multi - sum));
        }
        System.out.println(minDiff);
    }
}
