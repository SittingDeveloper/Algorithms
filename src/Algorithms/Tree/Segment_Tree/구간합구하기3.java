package Algorithms.Tree.Segment_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기3 {

    static long tree[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

        /* 트리의 높이를 구하는 공식*/
        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        /*=======================*/

        // totalNodeCount =  2^k * 2, == 2^(k+1)
        int totalNodeCount = (int)Math.pow(2, treeHeight + 1);
        int leftNodeStart = totalNodeCount / 2 - 1;

        // 0 번째 노드 사용X, + 1
        tree = new long[totalNodeCount + 1];

        // 트리 데이터 입력, i = leftNodeStart + 1 유의.
        // N == 5, 2^k >= 5, k =3, 2 * 2^3 = 16, 16 / 2 - 1 = 7
        // 7 == 가장 아래 바로 위 레벨의 최우측 노드, 즉 + 1 해줘야 마지막 레벨 시작노드.
        for (int i = leftNodeStart + 1; i <= leftNodeStart + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // tree 만들기, 2^4 == 16, 4depth 포화 이진 트리의 최대 노드 개수는 16 - 1 = 15개.
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

    // 트리 초기화
    private static void setTree(int totalNodeCount) {
        while (totalNodeCount != 1) {
            tree[totalNodeCount / 2] += tree[totalNodeCount];
            totalNodeCount--;
        }
    }

    // 값 변경
    private static void changeVal(int index, long val) {

        // 기존 값과 입력 값의 차이를 알아냄
        long diff = val - tree[index];

        // 선택된 인덱스의 트리노드의 부모노드들만 업데이트.
        // 부모를 찾아가는 방식은 index / 2
        while (index != 0) {
            tree[index] = tree[index] + diff;
            index /= 2;
        }

    }

    // 구간합
    private static long getSum(int s, int e) {

        long partSum = 0;

        // s , e 는 Index 값임에 유의.
        while (s <= e) {
            // startIndex 노드가 오른쪽 자식일 경우 선택
            if (s % 2 == 1) {
                partSum += tree[s];

                // 해당 노드의 부모노드는 필요 없으므로 오른쪽 노드의 부모로 이동하기 위해 s++
                s++;
            }

            // endIndex 노드가 왼쪽 자식일 경우 선택
            if (e % 2 == 0) {
                partSum += tree[e];

                // 해당 노드의 부모노드는 필요 없으므로 왼쪽 노드의 부모로 이동하기 위해 e--
                e--;
            }

            // 부모노드로 이동
            s = s / 2;
            e = e / 2;

        }
        return partSum;
    }

}
