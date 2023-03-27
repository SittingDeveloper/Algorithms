package Algorithms.Brute_Force;

import java.util.ArrayList;
import java.util.HashSet;

public class Programmers_후보키 {

    static String relation[][] = {
            {"100", "ryan", "music", "2"},
            {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"},
            {"400", "con", "computer", "4"},
            {"500", "muzi", "music", "3"},
            {"600", "apeach", "music", "2"}};

    // 백트래킹 문제
    // 유일성 : 중복이 단 하나도 없는 컬럼이여야 한다
    // 최소성 : 어떤 컬럼의 조합이 다른 컬럼에 포함되면 안된다.

    static boolean visited[];
    static int length;
    static int count;
    static HashSet<String> list = new HashSet<>(); // 백트래킹 중복 데이터를 거르는 리스트
    static ArrayList<String> list2 = new ArrayList<>(); // 후보키 개수

    public static void main(String[] args) {
        System.out.println(solution(relation));
    }

    static public int solution(String[][] relation) {
        int answer = 0;

        length = relation[0].length; // 컬럼 개수
        count = relation.length; // 튜플 개수
        visited = new boolean[length]; // 방문 체크

        // 조합이 1 ~ n개를 반복해서 조합
        for (int i = 1 ; i <= length ; i++) {
            comb(0, i);

            // 조합을 마친 뒤 유일성, 최소성을 따짐
            unique(relation);
            list.clear();
        }

        return list2.size();

    }

    // 백트래킹 부분
    static public void comb (int start, int r) {

        // 조합 탈출 조건 r == 0
        if ( r == 0 ) {
            String temp = "";
            for (int i = 0 ; i < length ; i++) {
                if (visited[i]) {
                    temp += i;
                }
            }
            list.add(temp);
        }

        for (int i = start ; i < length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(start + 1, r - 1);
                visited[i] = false;
            }
        }

    }

    static public void unique(String[][] relation){
        //유일성 판단하기
        for(String data:list){
            String[] temp= data.split("");
            int[] arr=new int[temp.length];
            for(int i=0;i<temp.length;i++){
                int c =Integer.parseInt(temp[i]);
                arr[i]=c;
            }
            //유일성 판단하기위한 set
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<count;i++){
                String cdd="";
                for(String data2:temp){
                    int c =Integer.parseInt(data2);
                    cdd+=relation[i][c];
                }
                set.add(cdd);
            }
            //만약 유일하다면 최소성 검사
            if(set.size()==count){
                boolean flag=false;
                for(String data3:list2){
                    int count=0;
                    String[] temp3= data3.split("");
                    for(String data4:temp3){
                        if(data.contains(data4)){
                            count++;
                        }
                    }
                    if(count==data3.length()){
                        flag=true;
                    }
                }
                if(!flag){
                    list2.add(data);
                }
            }
        }
    }

}
