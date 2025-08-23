import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static char arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];

        for(int i = 0; i < C; i++){
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0,0,0,0,"");
        System.out.print(sb.toString());
    }
    static void dfs(int idx,int a,int b,int cnt, String cur){
        if(cnt == L){
            if(a >= 1 && b >= 2){
                sb.append(cur).append("\n");
            }
            return;
        }
        if(idx == C) return;
        if (isVowel(arr[idx])) {
            dfs(idx+1, a+1, b, cnt+1, cur + arr[idx]);
        } else {
            dfs(idx+1, a, b+1, cnt+1, cur + arr[idx]);
        }
        dfs(idx + 1, a, b , cnt , cur);
    }
    static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
