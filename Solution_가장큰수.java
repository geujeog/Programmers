import java.util.*;

class Solution_가장큰수 {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }

        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                sb1.append(s1).append(s2);
                sb2.append(s2).append(s1);

                return sb2.toString().compareTo(sb1.toString());
            }
        });

        if (list.get(0).equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String num : list) {
            sb.append(num);
        }

        return sb.toString();
    }
}