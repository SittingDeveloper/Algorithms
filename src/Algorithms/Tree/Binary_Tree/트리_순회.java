package Algorithms.Tree.Binary_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1991
public class 트리_순회 {

    static int tree[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*
         * 트리의 노드와 배열의 인덱스 사이 상관 관계 (N : 노드의 개수)
         * 루트노드      : index = 1
         * 부모노드      : index = index / 2 && index != 1
         * 왼쪽자식노드   : index = index * 2 && index * 2 <= N
         * 오른쪽자식노드 : index = index * 2 + 1 && index * 2 + 1 <= N
         * */

        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2]; // N의 범위 26, 0 : 왼쪽자식 1 : 오른쪽자식

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            // 영문을 숫자로 바꾸려면 알파벳 'A'를 빼야함
            // String 형 숫자를 int 형 숫자로 바꾸려면 '0'을 빼야함
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

        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("tree[" + i + "][" + j + "] : " + tree[i][j] + "\n");
            }
            System.out.println();
        }*/

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

    }

     /* 호출 순서에 주의 !!!! */
    static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        // int 형 숫자를 알파벳으로 만들꺼면 + 'A'
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
