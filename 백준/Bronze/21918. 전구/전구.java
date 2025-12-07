import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                arr[b] = c;
            }
            else if(a == 2){
                for(int s = b; s <= c; s++){
                    arr[s] ^= 1;
                }
            }
            else if(a == 3){
                for(int s = b; s <= c; s++){
                    arr[s] = 0;
                }
            }
            else if(a == 4){
                for(int s = b; s <= c; s++){
                    arr[s] = 1;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}