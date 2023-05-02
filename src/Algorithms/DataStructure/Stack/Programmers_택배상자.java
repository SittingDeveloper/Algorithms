package Algorithms.DataStructure.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programmers_택배상자 {

    public static void main(String args[]) throws Exception {

        int order[] = {4, 3, 1, 2, 5};
//        int order[] = {5,4,3,2,1};
//        int order[] = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
//        int order[] = {2, 1, 6, 7, 5, 8, 4, 9, 3, 10};

        int answer = 0;

        Queue<Integer> container = new LinkedList<>();
        Stack<Integer> subContainer = new Stack<>();

        // Queue
        for (int i = 1; i <= order.length; i++) {
            container.add(i);
        }

        for (int i = 0; i < order.length; i++) {

            int target = order[i];

            // 컨테이너에 있을 경우 (Queue)
            if (container.size() > 0 && target == container.peek()) {
//                System.out.print(target + " ");
                answer++;
                container.poll();
            }

            // 서브컨테이너에 있을 경우 (Stack)
            else if (subContainer.size() > 0 && target == subContainer.peek()) {
//                System.out.print(target + " ");
                answer++;
                subContainer.pop();
            }

            // 모든 컨테이너의 입구에 없을 경우,
            // 컨테이너의 값을 서브컨테이너에 계속 집어넣으면서 order[i] 와 같은 값을 찾는다.
            // 끝까지 나오지 않을 경우에는 break
            else {

                if (!subContainer.isEmpty() && target < subContainer.peek()) {
                    break;
                }

                while (!container.isEmpty() && container.peek() != target) {
                    subContainer.push(container.poll());
                }

                if (!container.isEmpty() && container.peek() == target) {
                    answer++;
                    container.poll();
                }

            }
        }

        System.out.println(answer);

    }

}
