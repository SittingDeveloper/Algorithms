package Algorithms.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 올리브영_2번째_문제 {

    // testCase 1
    static String kor[] = {"AAA", "BCD", "AAAAA", "ZY"};
    static String usa[] = {"AB", "AA", "TTTT"};
    static String incs[] = {"AB BCD AA AAA TTTT AAAAA", "BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB", "AAA AB BCD"};

    // testCase 2
//    static String kor[] = {"CCC", "BCDF"};
//    static String usa[] = {"XXXX"};
//    static String incs[] = {"BCDF CCC", "XXXX"};

    public static void main(String[] args) {

        ArrayList<String> korArr = new ArrayList<>();
        ArrayList<String> usaArr = new ArrayList<>();

        for (int i = 0; i < kor.length; i++) {
            korArr.add(kor[i]);
        }

        for (int i = 0; i < usa.length; i++) {
            usaArr.add(usa[i]);
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < incs.length; i++) {

            StringTokenizer st = new StringTokenizer(incs[i]);

            ArrayList<String> korea = new ArrayList<>();
            ArrayList<String> united = new ArrayList<>();

            while (st.hasMoreTokens()) {
                String tempCountry = st.nextToken();
                if (korArr.contains(tempCountry)) {
                    korea.add(tempCountry);
                } else {
                    united.add(tempCountry);
                }
            }
            System.out.println("\n" + (i+1) + "번째 날");
            System.out.print("한국 : ");
            for (String s : korea) {
                System.out.print(s + " ");
            }

            System.out.print("\n미국 : ");
            for (String s : united) {
                System.out.print(s + " ");
            }

            System.out.println();

            for (int j = 0; j < korea.size(); j++) {
                for (int k = 0; k < united.size(); k++) {
                    String country = korea.get(j) + " " + united.get(k);
                    map.put(country, map.getOrDefault(country, 0) + 1);
                }
            }

        }

        int max = 0;
        for (String country : map.keySet()) {
//            System.out.println(country + " " + map.get(country));
            max = Math.max(map.get(country), max);
        }

        System.out.println(max);

    }

}
