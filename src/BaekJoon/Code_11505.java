package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11505 {

    static long tree[];
    static int Mod;

    public static void main(String[] args) throws IOException {

        Mod = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int totalNodeCount = (int) Math.pow(2, treeHeight + 1);
        int leftStartIndex = totalNodeCount / 2 - 1;

        tree = new long[totalNodeCount + 1];

        for (int i = leftStartIndex + 1; i <= leftStartIndex + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        setTree(totalNodeCount - 1);

        for (int i = 0; i < M + K; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeValue(b + leftStartIndex, (int)c);
            } else if (a == 2) {
                sb.append(getMultiple(b + leftStartIndex, Math.toIntExact(c + leftStartIndex)) + "\n");
            }

        }

        System.out.println(sb);

//        showTree(tree);

    }

    static void showTree(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void setTree(int i) {
        while (i >= 1) {
            tree[i / 2] = tree[i] * tree[--i] % Mod ;
            i--;
        }
    }

    static void changeValue(int index, int value) {

        tree[index] = value;

        while (index != 0) {

            if (index % 2 == 0) { // 왼쪽 자식 노드일 경우 오른쪽 값과 곱함
                tree[index / 2] = tree[index] * tree[index + 1] % Mod ;
            } else if (index % 2 == 1) { // 오른쪽 자식 노드일 경우 왼쪽 값과 곱함
                tree[index / 2] = tree[index] * tree[index - 1] % Mod ;
            }
            index /= 2;
        }

    }

    static long getMultiple(int s, int e) {

        long partResult = 1;

        while (s <= e) {

            if (s % 2 == 1) {
                partResult *= tree[s] % Mod ;
                s++;
                partResult %= Mod;
            }

            if (e % 2 == 0) {
                partResult *= tree[e] % Mod ;
                e--;
                partResult %= Mod;
            }

            s = s / 2;
            e = e / 2;

        }

        return partResult;
    }

}
