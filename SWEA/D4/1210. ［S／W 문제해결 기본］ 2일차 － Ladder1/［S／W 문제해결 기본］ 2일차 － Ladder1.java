import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            int map[][] = new int[100][100];
            int startCol = 0;
            StringTokenizer st;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        startCol = j;
                    }
                }
            }
            int row = 99;
            int col = startCol;
            while (row > 0) {
                if (col > 0 && map[row][col - 1] == 1) {
                    while (col > 0 && map[row][col - 1] == 1) {
                        col--;
                    }
                } else if (col < 99 && map[row][col + 1] == 1) {
                    while (col < 99 && map[row][col + 1] == 1) {
                        col++;
                    }
                }
                row--;
            }
            System.out.println("#" + test_case + " " + col);
        }
    }
}
