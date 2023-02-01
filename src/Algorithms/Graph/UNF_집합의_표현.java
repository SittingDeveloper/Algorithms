package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1717
public class UNF_집합의_표현 {

    static int unf[];

    static int find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            unf[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                int fa = find(Integer.parseInt(st.nextToken()));
                int fb = find(Integer.parseInt(st.nextToken()));

                if (fa == fb) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }

            }
        }

        System.out.println(sb);

    }

}