import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] input;
    static int[] permu;
    static int win, lose;
    static boolean[] usedCard;
    static boolean[] usedPermu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input = new int[9];
            permu = new int[9];
            usedCard = new boolean[19];
            usedPermu = new boolean[9];
            for (int i = 0; i < 9; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                usedCard[input[i]] = true;
            }
            for (int i = 1, idx = 0; i <= 18; i++) {
                if (!usedCard[i]) permu[idx++] = i;
            }
            win = 0; lose = 0;
            permutation(0,0,0);
            System.out.println("#"+test_case+" " + win + " " +lose);
        }
    }

    static void permutation(int depth, int sum1, int sum2) {
        if (depth == 9) {
            if(sum1 > sum2) win++;
            else if (sum1 < sum2) lose++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!usedPermu[i]) {
                usedPermu[i] = true;
                int roundSum = input[depth] + permu[i];
                if (input[depth] > permu[i]) {
                    permutation(depth + 1, sum1 + roundSum, sum2);
                }
                else {
                    permutation(depth + 1, sum1, sum2 + roundSum);
                }
                usedPermu[i] = false;
            }
        }
    }
}
