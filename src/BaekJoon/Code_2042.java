package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_2042 {

    static long tree[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int totalNodeCount = (int)Math.pow(2, treeHeight + 1);
        int leftNodeStart = totalNodeCount / 2 - 1; // input 5? == output 7

        tree = new long[totalNodeCount + 1];

        // 트리 데이터 입력
        for (int i = leftNodeStart + 1; i <= leftNodeStart + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // tree 만들기
        setTree(totalNodeCount - 1);

        for (int i = 0; i < M + K; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(b + leftNodeStart, c);
            } else if (a == 2) {
                sb.append(getSum(b + leftNodeStart, (int) (c + leftNodeStart)) + "\n");
            }

        }

        System.out.println(sb);

    }

    private static void setTree(int totalNodeCount) {
        while (totalNodeCount != 1) {
            tree[totalNodeCount / 2] += tree[totalNodeCount];
            totalNodeCount--;
        }
    }

    private static void changeVal(int index, long val) {

        long diff = val - tree[index];

        while (index != 0) {
            tree[index] = tree[index] + diff;
            index /= 2;
        }

    }

    private static long getSum(int s, int e) {

        long partSum = 0;

        while (s <= e) {
            // startIndex 노드가 오른쪽 자식일 경우 선택
            if (s % 2 == 1) {
                partSum += tree[s];
                s++;
            }

            // endIndex 노드가 왼쪽 자식일 경우 선탥
            if (e % 2 == 0) {
                partSum += tree[e];
                e--;
            }

            s = s / 2;
            e = e / 2;

        }
        return partSum;
    }

}
