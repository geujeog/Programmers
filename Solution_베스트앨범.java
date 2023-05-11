import java.util.*;

public class Solution_베스트앨범 {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, List<Integer>> genresMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                List<Integer> tmp = new ArrayList<>();

                if (genresMap.containsKey(genres[i])) {
                    tmp = genresMap.get(genres[i]);
                }

                tmp.add(i);
                genresMap.put(genres[i], tmp);
            }

            int cnt = 0;

            Iterator<String> iter = genresMap.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();

                if (genresMap.get(key).size() >= 2) cnt += 2;
                else cnt += 1;
            }

            List<Map.Entry<String, List<Integer>>> entrySet = new LinkedList<Map.Entry<String, List<Integer>>>(genresMap.entrySet());
            Collections.sort(entrySet, new Comparator<Map.Entry<String, List<Integer>>>(){
                @Override
                public int compare(Map.Entry<String, List<Integer>> a, Map.Entry<String, List<Integer>> b) {
                    Integer aCnt = 0;
                    Integer bCnt = 0;

                    for (int aNum : a.getValue()) {
                        aCnt += plays[aNum];
                    }
                    for (int bNum : b.getValue()) {
                        bCnt += plays[bNum];
                    }

                    return Integer.compare(bCnt, aCnt);
                }
            });

            int[] answer = new int[cnt];
            int idx = 0;

            for (Map.Entry<String, List<Integer>> entry : entrySet) {
                List<Integer> list = entry.getValue();

                Collections.sort(list, new Comparator<Integer>(){
                    @Override
                    public int compare (Integer a, Integer b) {
                        if (plays[a] == plays[b]) return 1;

                        return Integer.compare(plays[b], plays[a]);
                    }
                });

                answer[idx++] = list.get(0);

                if (list.size() >= 2) {
                    answer[idx++] = list.get(1);
                }
            }

            return answer;
        }
    }
