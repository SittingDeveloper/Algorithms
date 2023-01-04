package Algorithms.Sort.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2751
public class SortNumber {

    // https://yunmap.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%89%AC%EC%9A%B4-Merge-Sort-%EB%B3%91%ED%95%A9-%EC%A0%95%EB%A0%AC-%ED%95%A9%EB%B3%91-%EC%A0%95%EB%A0%AC

    public static int[] A;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, A.length - 1);

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void mergeSort(int startPoint, int endPoint) {

        if (startPoint < endPoint) {

            // 분할 진행
            int middlePoint = (startPoint + endPoint) / 2;
            mergeSort(startPoint, middlePoint);
            mergeSort(middlePoint + 1, endPoint);

            /*
            두 분할의 첫 번째 원소의 인덱스를 저장
            이 값을 저장하는 이유는 해당 인덱스의 값을 비교하여 어떤 원소를 참조할지 정하기 때문.
            start 는 항상 mid+1 보다 작기 때문에, 분할의 저장 위치는 start 지점이 된다. 그래서 int idx = p가 된다.
            */
            int firstPoint = startPoint;
            int secondPoint = middlePoint + 1;
            int idx = firstPoint;

             /* 안정 정렬이기 때문에 index 를 유지
             p가 middlePoint 이하이거나 q가 endPoint 이하일 때 동작해야한다.
             미만( < : X , <= : O )이 아닌 이유는 원소의 개수가 1개일 때 까지 쪼개야 하기 때문이다.
             그리고 동시에 종료가 되지 않을 수 있으니 두 경우를 &&로 하지 않고 || 로 하는 것에 주의하자. */
            while (firstPoint <= middlePoint || secondPoint <= endPoint) {

                /*
                첫 번째 분할에서 원소를 가져오는 경우는 다음과 같다.

                1. ( secondPoint > endpoint)
                두 번째 분할의 원소를 이미 다 가져온 경우

                2. ( firstPoint <= middlePoint && A[firstPoint] < A[secondPoint] )
                첫 번째 분할에서 가져오지 않은 원소가 있고, 첫 번째 분할의 첫 원소 값이 두 번째 분할의 첫 원소 값보다 작은 경우

                두 조건중 하나 이상 만족하면 첫 번째 분할에서 원소를 가져오므로 두 조건 사이에 or를 사용한다.

                if 문 결과에 따라 1번 분할의 첫 번째 값이나, 2번 분할의 첫 번째 값을 정렬된 값을 임시 저장하는 배열인 tmp 의 idx 에 저장
                이 때, 가져온 원소의 다음 인덱스를 비교하기 위해 firstPoint++ 또는 secondPoint++ 조건에 맞게 해 준다.
                idx 도 당연히 ++ 해줘야한다. 그 다음 최솟값을 찾아서 저장할 거니까.
                */
                if (secondPoint > endPoint || (firstPoint <= middlePoint && A[firstPoint] < A[secondPoint])) {
                    tmp[idx++] = A[firstPoint++];
                } else {
                    tmp[idx++] = A[secondPoint++];
                }

            }

            // 1번 분할과 2번 분할의 모든 원소를 가져오면 startPoint 부터 endPoint 까지 정렬된 값을 다시 A 배열에 저장해준다.
            for (int i = startPoint; i <= endPoint; i++) {
                A[i] = tmp[i];
            }
        }
    }

}
