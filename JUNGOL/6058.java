import java.io.*;

public class Main {
    static int n, ret = 0; 
    static int map[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                if(line.charAt(j) == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        dfs(0);
        System.out.print(ret);
    }
    
    static void dfs(int cur){
        if(cur == n){
            ret++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(map[cur][i] == 0 && !visited[i]){
                visited[i] = true;
                dfs(cur+1);
                visited[i] = false;
            }            
        }
    }
}
