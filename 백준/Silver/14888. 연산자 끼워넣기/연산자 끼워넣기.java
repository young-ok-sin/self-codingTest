import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int operator[], N, arr[];
    static int MAX_VALUE = Integer.MIN_VALUE, MIN_VALUE = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        operator= new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }


        dfs(1,arr[0]);
        System.out.println(MAX_VALUE);
        System.out.println(MIN_VALUE);
    }
    static void dfs(int idx, int current){
        if(idx == N){
            MAX_VALUE = Math.max(MAX_VALUE, current);
            MIN_VALUE = Math.min(MIN_VALUE,current);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--;

                int next = current;
                switch (i){
                    case 0: next += arr[idx]; break;
                    case 1: next -= arr[idx]; break;
                    case 2: next *= arr[idx]; break;
                    case 3:
                        if(next < 0)
                            next = -(-next / arr[idx]);
                        else
                            next /= arr[idx];
                        break;
                }
                dfs(idx+1, next);
                operator[i]++;
            }
        }


    }
}
