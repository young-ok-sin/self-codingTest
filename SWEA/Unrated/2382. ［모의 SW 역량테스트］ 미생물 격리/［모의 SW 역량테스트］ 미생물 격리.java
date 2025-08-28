import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Data{
        int num, dir, x, y, total;
        boolean isDead;
        public Data(int y, int x, int num, int dir) {
            this.x = x;
            this.y = y;
            this.total = this.num = num; //생성 시점에는 total과 num이 동일함
            this.dir = dir;
        }
    }

    static int N,M,K;
    static Data list[];
    static Data arr[][];
    static int dx[] = {0,0,0,-1,1}; // x상하좌우 순서
    static int dy[] = {0,-1,1,0,0};


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; ++test_case){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            list = new Data[K];
            arr = new Data[N][N];

            for(int i = 0; i < K; ++i) {
                st = new StringTokenizer(br.readLine());
                list[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            System.out.println("#" + test_case +" "+ move());

        }

    }

    static int move() {
        int time = M;
        int nx, ny, cnt = 0;
        while(time--> 0) {
            for(Data a : list) {
                if(a.isDead) continue;
                //단순 이동
                nx = a.x += dx[a.dir];
                ny = a.y += dy[a.dir];
                // 혹시 약 닿이면
                if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1 ) {
                    a.total = a.num = a.num/2;
                    if(a.num == 0) {
                        a.isDead = true;
                        continue;
                    }
                    if(a.dir % 2 == 1) a.dir++;
                    else a.dir--;
                }
                // 혹시 합치면
                if(arr[nx][ny] == null) {
                    arr[nx][ny] = a;
                }
                else {
                    if(arr[nx][ny].num > a.num) {
                        arr[nx][ny].total += a.num;
                        a.isDead = true;
                    }else {
                        a.total += arr[nx][ny].total;
                        arr[nx][ny].isDead = true;
                        arr[nx][ny] = a;
                    }
                }
            }
            cnt = reset();
        }
        return cnt;
    }
    private static int reset() {
        int total = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(arr[r][c]==null) continue;
                // 군집이 있다면 정리
                arr[r][c].num = arr[r][c].total;
                total += arr[r][c].num;
                arr[r][c] = null;
            }
        }
        return total;
    }
}
