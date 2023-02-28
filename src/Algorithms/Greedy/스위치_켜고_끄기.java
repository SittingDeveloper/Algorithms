package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1244
public class 스위치_켜고_끄기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        int N = Integer.parseInt(br.readLine());
        int Button[] = new int[N + 1];

        // 스위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Button[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수
        int students = Integer.parseInt(br.readLine());

        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int targetSwitch = Integer.parseInt(st.nextToken());

            // Male Student
            if (gender == 1) {
                // 배수값의 스위치를 reverse
                for (int j = targetSwitch; j <= Button.length; j = j + targetSwitch) {
                    if (j >= Button.length) {
                        continue;
                    }
                    Button[j] = Button[j] == 1 ? 0 : 1;
                }
            }

            // Female Student
            else {

                // 자신의 스위치는 반드시 reverse
                int targetIndex = targetSwitch;
                Button[targetIndex] = Button[targetIndex] == 1 ? 0 : 1;

                // 좌, 우측 인덱스 검사와 동시에 reverse 진행
                int prevIndex = targetIndex - 1;
                int postIndex = targetIndex + 1;

                // prev && post Index 존재할 때에만 reverse 가능
                while (prevIndex > 0 && postIndex <= Button.length - 1) {

                    // 0 0
                    if (Button[prevIndex] + Button[postIndex] == 0) {
                        Button[prevIndex] = 1;
                        Button[postIndex] = 1;
                    }

                    // 1 1
                    else if (Button[prevIndex] + Button[postIndex] == 2) {
                        Button[prevIndex] = 0;
                        Button[postIndex] = 0;
                    }

                    // 1 0 , 0 1
                    else {
                        break;
                    }

                    prevIndex--;
                    postIndex++;

                }

            }

        }

        // 20개 단위로 끊어서 출력
        int size = 0;
        for (int i = 1; i < Button.length; i++) {
            System.out.print(Button[i] + " ");
            size++;
            if (size == 20) {
                System.out.println();
                size = 0;
            }
        }

    }


}
