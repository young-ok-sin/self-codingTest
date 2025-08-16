package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_5567 {
    static boolean[] isVisited;
    static int n,m,sum;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        isVisited = new boolean[n+1];
        arr = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);
        }
        bfs();

        System.out.println(sum);
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        isVisited[1] = true;
        q.add(new int[]{1,0});

        while (!q.isEmpty()){
            int[] current = q.poll();

            int person = current[0];
            int depth = current[1];

            if(depth == 2){
                continue;
            }
            for(int i : arr[person]){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    sum++;
                    q.add(new int[]{i,depth+1});
                }
            }
        }
    }
}
