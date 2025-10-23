import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, time;
    static int A[][], origin_A[][];
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static Deque<Integer>[][] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[n][n];
        origin_A = new int[n][n];
        trees = new ArrayDeque[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                origin_A[i][j] = Integer.parseInt(st.nextToken());
                A[i][j] = 5;
                trees[i][j] = new ArrayDeque<>();
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees[x-1][y-1].add(z);
        }
        while (time < k){
            time++;
            springAndSummer();
            autumn();
            winter();
        }
        System.out.println(countTrees());
    }

    private static int countTrees() {
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cnt += trees[i][j].size();
            }
        }
        return cnt;
    }

    static void springAndSummer() {
        int[][] dead = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (trees[i][j].isEmpty()) continue;

                Deque<Integer> newDeque = new ArrayDeque<>();
                while (!trees[i][j].isEmpty()) {
                    int z = trees[i][j].pollFirst();

                    if (A[i][j] >= z) {
                        A[i][j] -= z;
                        newDeque.addLast(z + 1);
                    } else {
                        dead[i][j] += z / 2;
                    }
                }
                trees[i][j] = newDeque;
                A[i][j] += dead[i][j];
            }
        }
    }

    static void autumn(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (trees[i][j].isEmpty()) continue;

                for(int z : trees[i][j]){
                    if(z % 5 == 0){
                        for(int d = 0; d < 8; d++){
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if(nx < 0 || ny < 0 || nx >= n || ny >= n)   continue;
                            trees[nx][ny].addFirst(1);
                        }
                    }
                }
            }
        }
    }

    static void winter(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                A[i][j] += origin_A[i][j];
            }
        }
    }
}
