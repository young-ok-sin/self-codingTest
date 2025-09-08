import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int weights[] = new int[N+1];
            int profits[] = new int[N+1];

            int result[][] = new int[N+1][K+1];

            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                weights[i] = Integer.parseInt(st.nextToken());
                profits[i] = Integer.parseInt(st.nextToken());
            }
            int itemWeight = 0, itemBenefit = 0;
            for (int item = 1; item <= N; item++){
                itemWeight = weights[item];
                itemBenefit = profits[item];

                for(int weight = 1; weight <= K; weight++){
                    if(itemWeight <= weight){
                        result[item][weight] = Math.max(result[item-1][weight], itemBenefit + result[item-1][weight-itemWeight]);
                    }
                    else{
                        result[item][weight] = result[item-1][weight];
                    }
                }
            }
            System.out.println("#" + test_case + " " + result[N][K]);
        }
    }
}
