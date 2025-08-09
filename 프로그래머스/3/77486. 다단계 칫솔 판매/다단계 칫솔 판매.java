import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;

        // 1) 이름 -> 인덱스
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(enroll[i], i);

        // 2) 부모 포인터 설정
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            String ref = referral[i];
            if (!ref.equals("-")) parent[i] = idx.get(ref);
        }

        // 3) 수익 배열
        int[] earn = new int[n];

        // 4) 각 판매 건 처리
        for (int i = 0; i < seller.length; i++) {
            int cur = idx.get(seller[i]);
            int price = amount[i] * 100;

            while (cur != -1 && price > 0) {
                int up = price / 10;        // 부모에게 올라갈 금액
                int keep = price - up;      // 내가 가질 금액(= 90%)
                earn[cur] += keep;

                if (up < 1) break;          // 더 이상 전파할 금액이 없으면 종료

                cur = parent[cur];          // 부모로 이동
                price = up;                 // 전파 금액 갱신
            }
            // cur == -1 이면 센터로 가는 금액은 기록 안 함(문제 요구사항)
        }

        return earn;
    }
}
