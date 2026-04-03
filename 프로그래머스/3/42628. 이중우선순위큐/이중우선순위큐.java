import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int num = Integer.parseInt(split[1]);
            if (command.equals("I")) {
                maxQ.offer(num);
                minQ.offer(num);
                continue;
            }
            if (command.equals("D")) {
                if (num == 1) {
                    if (minQ.contains(maxQ.peek())) {
                        minQ.remove(maxQ.poll());
                    }
                } else {
                    if (maxQ.contains(minQ.peek())) {
                        maxQ.remove(minQ.poll());
                    }
                }
            }
        }
        
        if (maxQ.isEmpty() && minQ.isEmpty()) return new int[]{0,0};
        return new int[]{maxQ.poll(), minQ.poll()};
    }
}