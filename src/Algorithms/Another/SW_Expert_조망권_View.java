package Algorithms.Another;
import java.io.*;
import java.util.*;

// 1206. [S/W 문제해결 기본] 1일차 - View
public class SW_Expert_조망권_View {

    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++)
        {

            int TotalCount = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int buildings[] = new int[TotalCount];

            int cur = 0;
            while (st.hasMoreTokens()) {
                buildings[cur++] = Integer.parseInt(st.nextToken());
            }

            int count = 0;

            for (int i = 2 ; i < TotalCount-2 ; i++) {

                int prevprev = buildings[i-2];
                int prev = buildings[i-1];
                int current = buildings[i];
                int next = buildings[i+1];
                int nextnext = buildings[i+2];

                int leftMax = Math.max(prev, prevprev);
                int rightMax = Math.max(next,nextnext);
                int TotalMax = Math.max(leftMax, rightMax);

                if (prevprev < current && prev < current && next < current && nextnext < current) {
                    count += current - TotalMax;
                }

            }

            sb.append("#" + test_case + " " + count+ "\n");

        }

        System.out.println(sb);

    }

}
