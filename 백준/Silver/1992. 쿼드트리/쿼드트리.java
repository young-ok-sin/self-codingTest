import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }
        dfs(0,0,n);
        System.out.println(sb);
    }

    static void dfs(int x, int y, int size){

        int tmp = arr[x][y];
        for(int i = x; i < size+x; i++){
            for(int j = y; j < size+y; j++){
                if(tmp != arr[i][j]){
                    sb.append("(");
                    dfs(x,y,size/2);
                    dfs(x,y+size/2,size/2);
                    dfs(x+size/2, y, size/2);
                    dfs(x+size/2, y+size/2,size/2);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(tmp);
    }
}
