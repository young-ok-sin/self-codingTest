import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int max = 0; int king = 1;
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            int cnt = 0;

            for(int k = 0; k < n; k++){
                if(k == i)  continue;
                for(int j = 0; j < 5; j++){
                    if(arr[i][j] == arr[k][j]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max)  {
                max = cnt;
                king = i+1;
            }
        }
        System.out.println(king);
    }
}
