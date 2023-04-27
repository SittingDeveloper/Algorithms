package Algorithms.BackTracking;

public class Programmers_이모티콘_할인행사 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int users[][] = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int emoticons[] = {1300, 1500, 1600, 4900};

        for (int temp : solution.solution(users, emoticons)) {
            System.out.print(temp + " ");
        }
    }


    static class Solution {

        // 10%, 20%, 30%, 40% 할인율
        static int[] Rate = {90, 80, 70, 60};

        // 이모티콘Plus 가입자 수 총합
        static int EmoticonPlus = 0;

        // 판매액 총합
        static int TotalSales = 0;

        public int[] solution(int[][] users, int[] emoticons) {

            getPrices(emoticons, users, 0, new int[emoticons.length]);

            // 1. 가입자 수 최대한
            // 2. 이모티콘 판매액 최대한

            return new int[]{EmoticonPlus, TotalSales};
        }

        // BackTracking
        void getPrices(int emoticons[], int users[][], int depth, int rates[]) {

            // depth 가 이모티콘의 수 끝까지 내려가면 return
            if (depth == emoticons.length) {
                updateAnswer(emoticons, users, rates);
                return;
            }

            // 할인율을 바꿔가며 dfs 탐색
            for (int rate : Rate) {
                rates[depth] = rate;
                getPrices(emoticons, users, depth + 1, rates);
            }

        }

        void updateAnswer(int emoticons[], int users[][], int rates[]) {
            int ePlus = 0;
            int totalExpense = 0;

            for (int user[] : users) {
                int expense = 0; // 현재 구매 총 비용
                int rate = user[0]; // 사용자의 할인율
                int price = user[1]; // 사용자의 총액, 이 금액을 넘기면 ePlus++

                for (int i = 0 ; i < rates.length ; i++) {

                    // 이모티콘 구입 후 구매 총 비용에 더함 100% 할인이 아니라면
                    if (100 - rates[i] >= rate) {
                        expense += emoticons[i] * rates[i] / 100;
                    }

                    // 총 비용이 목표금액보다 높다면 구매한걸 전부 취소하고 이모티콘 플러스 가입
                    if (expense >= price) {
                        ePlus++;
                        expense = 0;
                        break;
                    }
                }

                totalExpense += expense;

            }

            if (ePlus > EmoticonPlus) {
                EmoticonPlus = ePlus;
                TotalSales = totalExpense;
            } else if (ePlus == EmoticonPlus) {
                TotalSales = Math.max(totalExpense, TotalSales);
            }

        }

    }

}
