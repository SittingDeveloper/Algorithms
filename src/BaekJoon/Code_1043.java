package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_1043 {

    static int unf[];
    static ArrayList<Integer> party[];

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N + 1];
        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int KnowsPeople = Integer.parseInt(st.nextToken());
        int arr_KnowsPeople[] = new int[KnowsPeople];
        for (int i = 0; i < KnowsPeople; i++) {
            arr_KnowsPeople[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<>();
            int partySize = Integer.parseInt(st.nextToken());

            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }

        }

        for (int i = 0; i < M; i++) {

            int firstPeople = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }

        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < arr_KnowsPeople.length; j++) {
                if (find(cur) == find(arr_KnowsPeople[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible == true) {
                result++;
            }
        }

        System.out.println(result);

    }

}
