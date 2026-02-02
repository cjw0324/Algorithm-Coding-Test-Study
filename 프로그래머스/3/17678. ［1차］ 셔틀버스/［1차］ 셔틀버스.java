import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> crew = new PriorityQueue<>();
        PriorityQueue<Integer> bus = new PriorityQueue<>();
        
        for (String time : timetable) {
            crew.add(stringToInt(time));
        }
        
        int busTime = 9 * 60;
        
        for (int i = 0; i<n; i++) {
            bus.add(busTime);
            busTime += t;
        }
        
        int answer = 0;
        int lastCrew = 0;
        boolean cornGetOn = false;
        while(!bus.isEmpty()) {
            int count = 0;
            int b = bus.poll();
            
            while(!crew.isEmpty()) {
                int c = crew.poll();
                if (b >= c && count < m) {
                    lastCrew = c;
                    count++;
                } else {
                    crew.add(c);
                    break;
                }
            }
            
            if (count < m) {
                answer = b;
            } else {
                answer = lastCrew - 1;
            }
        }
        return intToString(answer);
    }
    
    static int stringToInt (String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
    
    static String intToString (int time) {
        String hour = String.format("%02d", time/60);
        String min = String.format("%02d", time%60);
        return hour + ":" + min;
    }
}