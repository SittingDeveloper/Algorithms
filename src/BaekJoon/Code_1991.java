package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1991 {

    static int tree[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2]; // N의 범위 26, 0 : 왼쪽자식 1 : 오른쪽자식

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (leftChild == '.') {
                tree[parent][0] = -1;
            } else {
                tree[parent][0] = leftChild - 'A';
            }

            if (rightChild == '.') {
                tree[parent][1] = -1;
            } else {
                tree[parent][1] = rightChild - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

    }

    static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        System.out.print((char) (now + 'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    static void inOrder(int now) {
        if (now == -1) {
            return;
        }
        inOrder(tree[now][0]);
        System.out.print((char) (now + 'A'));
        inOrder(tree[now][1]);
    }

    static void postOrder(int now) {
        if (now == -1) {
            return;
        }
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char)(now + 'A'));

    }

}
