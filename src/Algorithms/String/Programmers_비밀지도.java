package Algorithms.String;

public class Programmers_비밀지도 {

    public static void main(String[] args) {

        int n = 5;
        int arr1[] = {9, 20, 28, 18, 11};
        int arr2[] = {30, 1, 21, 17, 28};

        for (String temp : solution(n, arr1, arr2)) {
            System.out.println(temp);
        }

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        /*
        '정사각형' 배열 n
        " " 공백
        OR
        "#" 벽
        지도1, 지도2 중 하나라도 "#" 인 부분은 찐 지도에서 벽임. (OR)
        지도1, 지도2 모두 공백인 부분은 찐 지도에서도 공백. (AND)
        */

        String formatSpecifer = "%" + n + "s";
        String BinaryString_1[] = new String[n];
        String BinaryString_2[] = new String[n];


        for (int i = 0 ; i < n ; i++) {
            BinaryString_1[i] = String.format(formatSpecifer, Integer.toBinaryString(arr1[i])).replace(' ', '0');
            BinaryString_2[i] = String.format(formatSpecifer, Integer.toBinaryString(arr2[i])).replace(' ', '0');

            String temp = "";

            for (int j = 0 ; j < n ; j++) {
                if ( BinaryString_1[i].charAt(j) == '1' ||  BinaryString_2[i].charAt(j) == '1' ) {
                    temp += "#";
                } else {
                    temp += " ";
                }
            }

            answer[i] = temp;

        }



        return answer;
    }

}
