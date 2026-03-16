import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, len;
    static int[] arr, count;
    static int getMin(){
        for(int i = 1; i <= 10; i++){
            if(count[i] > 0) return i;
        }
        return 0;
    }
    static int getMax(){
        for(int i = 10; i >= 1; i--){
            if(count[i] > 0) return i;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        count = new int[11];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0; len = 0;
        for(int r = 0; r < n; r++){
            count[arr[r]]++;
            while(getMax() - getMin() > 2){
                count[arr[l]]--;
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        System.out.println(len);
    }
}
