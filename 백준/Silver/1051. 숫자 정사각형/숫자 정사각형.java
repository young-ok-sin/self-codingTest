import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,max;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        max = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int size = 1; i + size < n && j + size < m; size++){
                    if(arr[i][j] == arr[i][size+j] && arr[i][j] == arr[i+size][j] && arr[i][j] == arr[i+size][j+size]){
                        max = Math.max(max, (size+1)*(size+1));
                    }
                }
            }
        }
        System.out.println(max);
    }
}
