package Algorithms.BackTracking;

import java.util.HashSet;

public class Programmers_불량_사용자 {

    static String userIds[]; // 사용자 아이디 목록을 담을 배열
    static String bannedIds[]; // 밴 아이디 목록을 담을 배열
    static boolean Visited[]; // 방문 여부를 체크할 배열
    static HashSet<HashSet<String>> result = new HashSet<>(); // 결과 집합을 담을 HashSet

    public static void main(String[] args) {

        String user_id[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; // 예시 데이터
        String banned_id[] = {"fr*d*", "abc1**"}; // 예시 데이터

        // 깊은 복사, user_id 및 banned_id 에 직접 사용하면 꼬임
        userIds = user_id;
        bannedIds = banned_id;

        Visited = new boolean[userIds.length]; // 방문 배열 초기화

        dfs(new HashSet<>(), 0); // DFS 탐색 시작

        System.out.println(result.size()); // 결과 집합의 크기 출력

    }

    private static void dfs(HashSet<String> set, int depth) {

        if (depth == bannedIds.length) { // 밴 아이디를 모두 체크한 경우
            result.add(set); // 결과 집합에 추가하고
            return; // DFS 탐색 종료
        }

        for (int i = 0; i < userIds.length; i++) {

            if (set.contains(userIds[i])) { // 이미 집합에 포함된 경우 건너뛴다
                continue;
            }

            if (check(userIds[i], bannedIds[depth])) { // 아이디가 밴 아이디와 일치하는 경우
                set.add(userIds[i]); // 집합에 추가하고
                dfs(new HashSet<>(set), depth + 1); // 다음 밴 아이디 체크를 위해 DFS 호출
                set.remove(userIds[i]); // 백트래킹
            }

        }
    }

    private static boolean check(String userId, String bannedId) {

        // 가지치기
        if (userId.length() != bannedId.length()) { // 길이가 다르면 불일치
            return false;
        }

        // 길이가 같다면 두 문자열을 처음부터 끝까지 각 자리 비교
        boolean match = true;
        for (int i = 0; i < userId.length(); i++) {
            // '*' 문자가 아니면서 불일치
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }

        return match;

    }

}
