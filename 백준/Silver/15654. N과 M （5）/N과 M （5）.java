import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M, arr[],result[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = new int[M];
        back(0);
    }
    static void back(int depth){
        //기저 조건 : depth가 M이면 출력
        StringBuilder sb = new StringBuilder();
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            result[depth] = arr[i];
            back(depth+1);
            visited[i] = false;
        }
    }
}
