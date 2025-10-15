import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static boolean isPrime[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N+1];

        if(N == 1){
            System.out.println(0);
            return;
        }

       for(int i = 2; i <= N; i++){
           isPrime[i] = true;
       }

       for(int i = 2; i * i <= N;i++){
           if(!isPrime[i]) continue;
           for(int j = i * i ; j <= N; j += i){
               isPrime[j] = false;
           }
       }

       ArrayList<Integer> list = new ArrayList<>();
       for(int i = 2; i <= N; i++){
           if(isPrime[i]) list.add(i);
       }

       int left = 0, right = 0, sum = 0, cnt = 0;
       while (true){
           if(sum >= N){
               if(sum == N) cnt++;
               sum -= list.get(left++);
           }
           else{
               if(right == list.size()) break;
               sum += list.get(right++);
           }
       }
        System.out.println(cnt);
    }
}
