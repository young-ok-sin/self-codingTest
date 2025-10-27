import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static ArrayList<Point> points = new ArrayList<>();

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = line.charAt(j) - '0';
                if (arr[i][j] == 0) {
                    points.add(new Point(i, j));
                }
            }
        }

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == points.size()) {
            print();
            System.exit(0);
        }

        Point p = points.get(depth);

        for (int num = 1; num <= 9; num++) {
            if (isValid(p.x, p.y, num)) {
                arr[p.x][p.y] = num;
                dfs(depth + 1);
                arr[p.x][p.y] = 0;
            }
        }
    }

    static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == num) return false;
            if (arr[i][y] == num) return false;
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (arr[i][j] == num) return false;
            }
        }

        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}