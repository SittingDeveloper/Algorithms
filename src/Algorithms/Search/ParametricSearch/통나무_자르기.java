package Algorithms.Search.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2805
public class 통나무_자르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 나무의 수
        int N = Integer.parseInt(st.nextToken());

        // 가져가려는 목재의 길이
        int M = Integer.parseInt(st.nextToken());

        // 목재 배열
        int arr[] = new int[N];
        int startParameter = 0;
        int endParameter = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            endParameter = Math.max(arr[i], endParameter);
        }

        /* Q. M만큼 목재를 가져가기 위해서 절단기를 최대한 몇 까지 늘려야하는가? */
        while (startParameter <= endParameter) {

            int midParameter = (startParameter + endParameter) / 2;

            long wood = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > midParameter) {
                    wood += arr[i] - midParameter;
                }
            }

            // target == wood
            /*
             * 자른 나무 길의의 합이 M보다 작다는 것은
             * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
             * 즉, 상한(max)를 줄여야 한다.
             */
            if (wood < M) {
                endParameter = midParameter - 1;
            }

            /*
             * 자른 나무 길이의 합이 M보다 크다는 것은
             * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
             * 또한, 같을 경우에는 최대한 적게 자르기 위해 자르는 높이를
             * 높여야 하므로 하한(min)을 올려야 한다.
             */
            else {
                startParameter = midParameter + 1;
            }

        }
        System.out.println(endParameter);

    }

}
