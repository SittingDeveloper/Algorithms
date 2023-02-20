package Algorithms.Tree.Segment_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10868
public class 최소값_찾기 {

    static long tree[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N : 노드의 개수 ,  M : 최솟값 구하는 범위 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            sb.append(findMin((start + leftStartIndex), Math.toIntExact(end + leftStartIndex)) + "\n");
        }

        System.out.println(sb);

//        printTree(tree);

    }

    private static void printTree(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 트리 초기화
    private static void setTree(int totalNodeCount) {
        while (totalNodeCount != 1) {
            tree[totalNodeCount / 2] = Math.min(tree[totalNodeCount], tree[--totalNodeCount]);
            totalNodeCount--;
        }
    }

    // 최소값 찾기
    private static long findMin(int s, int e) {

        long min = Long.MAX_VALUE;

        while (s <= e) {

            if (s % 2 == 1) {
                min = Math.min(tree[s], min);
                s++;
            }

            if (e % 2 == 0) {
                min = Math.min(tree[e], min);
                e--;
            }

            s = s / 2;
            e = e / 2;

        }

        return min;

    }

}
