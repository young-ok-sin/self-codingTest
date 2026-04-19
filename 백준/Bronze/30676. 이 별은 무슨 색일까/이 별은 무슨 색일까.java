import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        if(620 <= input && input <= 780){
            System.out.println("Red");
        } else if (590 <= input && input <= 620) {
            System.out.println("Orange");
        }else if (570 <= input && input <= 590) {
            System.out.println("Yellow");
        }else if (495 <= input && input <= 570) {
            System.out.println("Green");
        }else if (450 <= input && input <= 495) {
            System.out.println("Blue");
        }else if (425 <= input && input <= 450) {
            System.out.println("Indigo");
        }else if (380 <= input && input <= 425) {
            System.out.println("Violet");
        }
    }
}
