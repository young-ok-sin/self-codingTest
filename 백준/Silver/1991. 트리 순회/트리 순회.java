import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        char value;
        Node left;
        Node right;
        Node(char value){
            this.value = value;
        }
    }
    static Map<Character,Node> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.putIfAbsent(root,new Node(root));

            if(left != '.'){
                tree.putIfAbsent(left,new Node(left));
                tree.get(root).left = tree.get(left);
            }
            if(right != '.'){
                tree.putIfAbsent(right,new Node(right));
                tree.get(root).right = tree.get(right);
            }
        }
        Node root = tree.get('A');

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();

    }
    static void preorder(Node node){
        if(node == null)    return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node){
        if(node == null)    return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }
    static void postorder(Node node){
        if(node == null)    return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
