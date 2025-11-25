import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static ArrayList<Integer>[] list;
    static StringTokenizer st;
    static int seat[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int size = N*N;
        list = new ArrayList[size + 1];
        for(int i = 1; i <= size; i++){
            list[i] = new ArrayList<>();
        }

        int order[] = new int[size];
        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            order[i] = u;
            for(int j = 0; j < 4; j++){
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
            }
        }
        seat = new int[N][N];
        for(int i = 0; i < size; i++){
            place(order[i]);
        }
        System.out.println(calc());
    }

    static void place(int u){
        int bestR = -1, bestC = -1;
        int bestFav = -1, bestEmpty = -1;

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(seat[r][c] != 0) continue;

                int favCnt = 0;
                int emptyCnt = 0;

                for(int d = 0; d < 4; d++){
                    int nr = r + dx[d];
                    int nc = c+ dy[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    if (seat[nr][nc] == 0) emptyCnt++;
                    else if (list[u].contains(seat[nr][nc])) favCnt++;
                }

                if(favCnt > bestFav
                    || (favCnt == bestFav && emptyCnt > bestEmpty)
                    || (favCnt == bestFav && emptyCnt == bestEmpty && (bestR == -1 || r < bestR || (r == bestR && c < bestC)))){
                    bestR = r;
                    bestC = c;
                    bestFav = favCnt;
                    bestEmpty = emptyCnt;
                }
            }
        }
        seat[bestR][bestC] = u;
    }

    static int calc(){
        int total = 0;
        int[] score = {0,1,10,100,1000};

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                int u = seat[r][c];
                int favCnt = 0;

                for(int d = 0; d < 4; d++){
                    int nr = r + dx[d];
                    int nc = c + dy[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (list[u].contains(seat[nr][nc])) favCnt++;
                }
                total += score[favCnt];
            }
        }
        return total;
    }
}
