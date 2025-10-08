import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        int cnt = 1;


        while(B > A){
            if(B % 2 == 0){
                B /= 2;
            }
            else if(B % 10 == 1){
                B /= 10;
            }
            else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(B == A ? cnt : -1);
    }
}
