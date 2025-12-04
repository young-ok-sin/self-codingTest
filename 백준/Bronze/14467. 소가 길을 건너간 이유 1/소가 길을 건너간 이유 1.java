import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, ret;
    static int[]cow;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cow = new int[11];
        Arrays.fill(cow, -1);

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int po = Integer.parseInt(st.nextToken());

            if(cow[num] == -1){
                cow[num] = po;
            } else if (cow[num] != po) {
                ret++;
                cow[num] = po;
            }
        }
        System.out.println(ret);
    }

}
