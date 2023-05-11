import java.util.*;

public class Solution_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> all = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int top : topping) {
            all.put(top, all.getOrDefault(top, 0) + 1);
        }

        for (int top : topping) {
            set.add(top);

            all.put(top, all.get(top) - 1);
            if (all.get(top) == 0) {
                all.remove(top);
            }

            if (all.size() == set.size()) answer++;
        }

        return answer;
    }
}