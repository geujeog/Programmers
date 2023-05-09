import java.util.*;

class Solution_소수찾기 {
    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        // 모든 경우의 수
        for (int i = 1; i <= numbers.length(); i++) {
            boolean[] check = new boolean[numbers.length()];

            findAll(set, numbers, new StringBuilder(), i, check);
        }

        // 소수인지 판별
        for (Integer s : set) {
            if (check(s)) answer++;
        }

        return answer;
    }

    public boolean check (int n) {
        if (n == 0 || n == 1) return false;

        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void findAll (Set<Integer> set, String numbers, StringBuilder sb, int total, boolean[] check) {
        if (sb.length() == total) {
            if (sb.length() == total) {
                set.add(Integer.parseInt(sb.toString()));
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (check[i]) continue;

            check[i] = true;
            sb.append(numbers.charAt(i));

            findAll(set, numbers, sb, total, check);

            sb.deleteCharAt(sb.length()-1);
            check[i] = false;
        }
    }
}