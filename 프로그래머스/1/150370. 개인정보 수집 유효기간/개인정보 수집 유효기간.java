import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();

        int i = 1;
        for (String p : privacies) {
            String[] privace = p.split(" ");
            int dayDiff = dayCount(today, privace[0]);
            int termDay = searchTerms(privace[1], terms);
            System.out.println("약관 종류 : " + privace[1]);
            System.out.println("보관 기간 : " + dayDiff +" , 유효기간 : " + termDay);
            if (dayDiff >= termDay) {
                answer.add(i);
            }
            i++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int dayCount (String today, String getday) {
        String[] todayTemp = today.split("\\.");
        String[] getdayTemp = getday.split("\\.");
        int year = Integer.parseInt(todayTemp[0]) - Integer.parseInt(getdayTemp[0]);
        int month = Integer.parseInt(todayTemp[1]) - Integer.parseInt(getdayTemp[1]);
        int day = Integer.parseInt(todayTemp[2]) - Integer.parseInt(getdayTemp[2]);
        
        return day + (month * 28) + (year * 12 * 28);
    }
    
    public int searchTerms(String s, String[] terms) {
        for (String term : terms) {
            String[] termTemp = term.split(" ");
            if (termTemp[0].equals(s)) {
                return Integer.parseInt(termTemp[1]) * 28;
            }
        }
        
        return 0;
    }
}