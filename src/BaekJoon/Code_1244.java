package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1244 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int Button[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Button[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());

        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int targetSwitch = Integer.parseInt(st.nextToken());

            // Male Student
            if (gender == 1) {
                for (int j = targetSwitch; j <= Button.length; j = j + targetSwitch) {
                    if (j >= Button.length) {
                        continue;
                    }
                    Button[j] = Button[j] == 1 ? 0 : 1;
                }

            }

            // female Student
            else {

                int targetIndex = targetSwitch;
                Button[targetIndex] = Button[targetIndex] == 1 ? 0 : 1;

                int prevIndex = targetIndex - 1;
                int postIndex = targetIndex + 1;

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
