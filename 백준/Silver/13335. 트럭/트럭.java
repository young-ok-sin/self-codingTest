import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, W, L, time;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();
        int weight = 0;
        int idx = 0;
        for(int i = 0; i < W; i++)  q.offer(0);

        while(!q.isEmpty()){
            time++;
            weight -= q.poll();

            if(idx < N){
                if(weight + arr[idx] <= L){
                    q.offer(arr[idx]);
                    weight += arr[idx];
                    idx++;
                }
                else{
                    q.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}
