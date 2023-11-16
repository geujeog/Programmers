import java.util.*;

public class Solution_이중우선순위큐 {

    public int[] solution(String[] operations) {
        Stack<Integer> bigger = new Stack<>();
        Stack<Integer> smaller = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");

            String command = op[0];
            int num = Integer.parseInt(op[1]);

            if ("I".equals(command)) {
                insertStack(bigger, smaller, num);
            }
            else if ("D".equals(command) && num == 1) { // 최대값 삭제
                removeMax(bigger, smaller);
            }
            else if ("D".equals(command) && num == -1) { // 최솟값 삭제
                removeMin(bigger, smaller);
            }
        }

        return getMinAndMax(bigger, smaller);
    }

    public int[] getMinAndMax(Stack<Integer> bigger, Stack<Integer> smaller) {
        int[] answer = new int[2];

        if (!bigger.isEmpty() && !smaller.isEmpty()) {
            while (!bigger.isEmpty()) {
                answer[1] = bigger.pop();
            }
            while (!smaller.isEmpty()) {
                answer[0] = smaller.pop();
            }
        }
        else if (!bigger.isEmpty()) {
            answer[0] = bigger.peek();
            while (!bigger.isEmpty()) {
                answer[1] = bigger.pop();
            }
        }
        else if (!smaller.isEmpty()) {
            answer[1] = smaller.peek();
            while (!smaller.isEmpty()) {
                answer[0] = smaller.pop();
            }
        }

        return answer;
    }

    public void insertStack(Stack<Integer> bigger, Stack<Integer> smaller, int num) {
        if (smaller.isEmpty() || smaller.peek() > num) {
            moveBiggerToSmaller(bigger, smaller, num);
        }
        else if (bigger.isEmpty() || bigger.peek() < num) {
            moveSmallerToBigger(bigger, smaller, num);
        }
        smaller.add(num);
    }

    public void moveBiggerToSmaller(Stack<Integer> bigger, Stack<Integer> smaller, int num) {
        while (!bigger.isEmpty() && bigger.peek() >= num) {
            smaller.add(bigger.pop());
        }
    }

    public void moveSmallerToBigger(Stack<Integer> bigger, Stack<Integer> smaller, int num) {
        while(!smaller.isEmpty() && smaller.peek() < num) {
            bigger.add(smaller.pop());
        }
    }

    public void removeMin(Stack<Integer> bigger, Stack<Integer> smaller) {
        if (!bigger.isEmpty()) {
            bigger.remove(0);
        }
        else {
            if (!smaller.isEmpty()) {
                smaller.pop();
            }
        }
    }

    public void removeMax(Stack<Integer> bigger, Stack<Integer> smaller) {
        if (!smaller.isEmpty()) {
            smaller.remove(0);
        }
        else {
            if (!bigger.isEmpty()) {
                bigger.pop();
            }
        }
    }
}
