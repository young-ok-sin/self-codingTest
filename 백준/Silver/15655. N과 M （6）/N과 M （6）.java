import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,arr[], result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0,0);
    }
    static void back(int idx, int depth){
        StringBuilder sb = new StringBuilder();
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = idx; i < N; i++){
            result[depth] = arr[i];
            back(i+1,depth+1);
        }
    }
}
