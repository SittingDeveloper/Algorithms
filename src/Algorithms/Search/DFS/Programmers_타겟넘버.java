package Algorithms.Search.DFS;

public class Programmers_타겟넘버 {

    static int answer;
    static int numbers[] = {1,1,1,1,1};
    static int target = 3;

    public static void main(String[] args) {
        answer = 0;

        dfs(0, 0);

        System.out.println(answer);
    }

    /*
    index : 이번 dfs call에서 더하거나 빼야 될 그 숫자가 위치한 인덱스
      sum : 누적합
      다음 번 재귀 함수를 Call 할 때 현재 인덱스의 숫자를 Sum에 더하거나 빼는 동작을 함.
    */
    static void dfs(int index ,int sum) {

        // 1. 탈출 조건 (뒤에 구현하지만 앞에 써야함)
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 2. 수행 동작 (먼저 구현하지만 뒤에 써야함)
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);

    }

}
