import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static Long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        int start =  1;
        int end = 0;
        long sum = 0L;
        int f[] = new int[S];
        for(int i = 0; i < S; i++){
            f[i] = Integer.parseInt(br.readLine());
            sum += f[i];
            end = Math.max(end, f[i]);
        }

        int result = 0; // 최대 크기
        while(start <= end){
            int mid = (start+end)/2;

            int cnt = 0;
            for(int i = 0; i < S; i++){
                cnt += f[i] / mid;
            }

            if(cnt >= C){
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        long ans = sum - (C * result);
        System.out.println(ans);
    }
}
