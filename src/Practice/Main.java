package Practice;


import java.io.*;

public class Main {

    static int A[];
    static int tmp[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

         mergeSort(0, N-1);

        for (int i = 0 ; i < N ; i++) {
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static void mergeSort(int startPoint, int endPoint) {

        if (startPoint < endPoint) {

            int middlePoint = (startPoint + endPoint) / 2;

            // Split
            mergeSort(startPoint, middlePoint);
            mergeSort(middlePoint + 1, endPoint);

            int firstPoint = startPoint;
            int secondPoint = middlePoint + 1;
            int idx = firstPoint;

            // Merge
            while (firstPoint <= middlePoint || secondPoint <= endPoint) {

                if (secondPoint > endPoint || (firstPoint <= middlePoint && A[firstPoint] < A[secondPoint])) {
                    tmp[idx++] = A[firstPoint++];
                } else
                    tmp[idx++] = A[secondPoint++];

            }

            for (int i = startPoint; i <= endPoint; i++) {
                A[i] = tmp[i];
            }

        }

    }

}