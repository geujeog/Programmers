public class Solution_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 0;
        int end = 0;

        for (int station : stations) {
            end = station - w - 1;

            if (start < end) {
                answer += ((end - start) / (2*w + 1));
                answer += ((end - start) % (2*w + 1) == 0) ? 0 : 1;
            }

            start = station + w;
        }

        end = n;

        if (start < end) {
            answer += ((end - start) / (2*w + 1));
            answer += ((end - start) % (2*w + 1) == 0) ? 0 : 1;
        }

        return answer;
    }
}