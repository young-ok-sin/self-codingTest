import java.util.*;
import java.io.*;

public class Main {
    static int c, r, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        if(r * c < k){
            System.out.print(0);
            return;
        } 

        int num = 0;
        int layer = 0;
    
        while(true){
            int x = layer + 1;
            int y = layer + 1;
            num++;
            if(num == k){
                finish(x,y);
                return;
            }

            //상
            while(y < r - layer){
                y++;
                num++;
                if(num == k){
                    finish(x,y);
                    return;
                }
            }
            //우
            while(x < c - layer){
                x++;
                num++;
                if(num == k){
                    finish(x,y);
                    return;
                }
            }
            //하
            while(y > 1 + layer){
                y--;
                num++;
                if(num == k){
                    finish(x,y);
                    return;
                }
            }
            //좌
            while(x > 2 + layer){
                x--;
                num++;
                if(num == k){
                    finish(x,y);
                    return;
                }
            }
            layer++;


        }
    }

    static void finish(int x, int y){
        System.out.print(x + " " + y);
        return;
    }
}
