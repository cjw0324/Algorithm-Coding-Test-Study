import java.util.*;
class Solution {
    static int basic_time, basic_fee, minute_unit, minute_fee; 
    public int[] solution(int[] fees, String[] records) {
        basic_time = fees[0];
        basic_fee = fees[1];
        minute_unit = fees[2];
        minute_fee = fees[3];
        
        List<String> cars;
        HashSet<String> cars_set = new HashSet<>();
        HashMap<String, Integer> record_map = new HashMap<>();
        HashMap<String, Integer> using_time = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            int time = stringToInt(split[0]);
            String car_no = split[1];
            String type = split[2];
            cars_set.add(car_no);
            if (type.equals("IN")) {
                cars_set.add(car_no);
                record_map.put(car_no, time);
            } else {
                int used = time - record_map.get(car_no);
                record_map.remove(car_no);
                using_time.put(car_no, using_time.getOrDefault(car_no, 0) + used);
            }
        }
        
        if (record_map.keySet().size() > 0) {
            for (String car_no : record_map.keySet()) {
                int used = (23 * 60) + 59 - record_map.get(car_no);
                using_time.put(car_no, using_time.getOrDefault(car_no, 0) + used);
            }
        }
        
        cars = new ArrayList<>(cars_set);
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        int index = 0;
        for (String car : cars) {
            answer[index] = getCost(using_time.get(car));
            index++;
        }
        return answer;
        
        
    }
    
    private static int getCost(int time) {
        time-= basic_time;
        if (time <= 0) return basic_fee;
        int cost = basic_fee;
        cost += ((time / minute_unit) * minute_fee);
        if (time % minute_unit != 0) cost += minute_fee;
        return cost;
    }
    
    private static int stringToInt(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}