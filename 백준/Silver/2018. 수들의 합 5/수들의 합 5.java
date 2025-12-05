import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int start = 1;
        int sum = 1;
        int end = 1;

        while(start <= N){
            if(sum == N){
                cnt++;
                sum -= start;
                start++;
            }else if(sum < N){
                end++;
                if(end > N) break;
                sum += end;
            }else{
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);
    }
}