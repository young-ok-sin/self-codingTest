import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(isPrime(arr[i])) res++;
        }
        System.out.println(res);
    }
    static boolean isPrime(int n){
        if(n < 2)   return false;
        if(n == 2)  return true;
        if(n % 2 == 0)  return false;
        
        for(int i = 3; i * i <= n; i+=2){
            if(n % i == 0)return false;
        }
        return true;
    }
}
