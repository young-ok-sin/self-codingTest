import java.util.Scanner;

public class Main {
    static int R, C, result;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[] alpa = new boolean[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        arr = new int[R][C];
        for(int i = 0; i < R; i ++){
            String line = sc.next();
            for(int j = 0; j < C; j++){
                arr[i][j] = line.charAt(j) - 'A';
            }
        }

        alpa[arr[0][0]] = true;
        dfs(0,0,1);
        System.out.println(result);
    }
    static void dfs(int x, int y,int cnt){
        result = Math.max(cnt,result);

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cy >= 0 && cx < R && cy <C){
                if(!alpa[arr[cx][cy]]){
                    alpa[arr[cx][cy]] = true;
                    dfs(cx,cy,cnt+1);
                    alpa[arr[cx][cy]] = false;
                }
            }
        }
    }
}
