import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr,tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[]{1,1,2,2,2,8};
        tmp = new int[6];
        for(int i = 0; i < 6; i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 6; i++){
            System.out.print(arr[i] - tmp[i] + " ");
        }
    }
}
