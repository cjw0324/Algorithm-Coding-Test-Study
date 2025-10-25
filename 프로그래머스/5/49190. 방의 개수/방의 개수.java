import java.util.*;
class Solution {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int answer = 0;
    static Map<Node, List<Node>> visited; 
    public int solution(int[] arrows) {
        visited = new HashMap<>();
        Node now = new Node(0,0);
        
        for (int arrow : arrows) {
            for (int i = 0; i<2; i++) {
                Node next = new Node(now.x + dx[arrow], now.y + dy[arrow]);
                
                if (!visited.containsKey(next)) {
                    visited.put(next, getList(now));
                    List<Node> temp = visited.getOrDefault(now, getEmptyList());
                    temp.add(next);
                    visited.put(now, temp);
                } else if (!visited.get(next).contains(now)) {
                    visited.get(next).add(now);
                    visited.get(now).add(next);
                    answer++;
                }
                
                
                now = next;
            }
        }
        
        return answer;
    }
    
    static List<Node> getEmptyList() {
        List<Node> list = new ArrayList<>();
        return list;
    }
    
    static List<Node> getList(Node node) {
        List<Node> list = new ArrayList<>();
        list.add(node);
        return list;
    }
    
    static class Node {
        int x;
        int y;
        
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return this.x == n.x && this.y == n.y;
        }
        
        @Override
        public int hashCode() {
            return 31 * this.x * this.y;
        }
    }
}