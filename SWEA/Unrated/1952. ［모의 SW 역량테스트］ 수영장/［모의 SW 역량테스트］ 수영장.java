import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int price[], schedule[], min_value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            price = new int[4];
            schedule = new int[13];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int p = 0; p < 4; p++){
                price[p] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int s = 1; s <= 12; s++){
                schedule[s] = Integer.parseInt(st.nextToken());
            }
            min_value = price[3];
            dfs(1,0);

            System.out.println("#" + test_case + " " + min_value);
        }
    }
    static void dfs(int month, int cost){
        if(month > 12){
            min_value = Math.min(min_value, cost);
            return;
        }

        if(cost > min_value)    return;

        if(schedule[month] == 0)
            dfs(month + 1, cost);
        else{
            //1일권
            dfs(month + 1, cost + (schedule[month] * price[0]));
            //1달
            dfs(month + 1, cost + price[1]);
            //3개월
            dfs(month + 3, cost + price[2]);
        }
    }
}
