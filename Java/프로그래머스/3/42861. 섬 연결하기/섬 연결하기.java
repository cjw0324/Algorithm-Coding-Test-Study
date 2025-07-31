import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        Edge[] edges = new Edge[costs.length];
        for (int i = 0; i< edges.length; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Node[] nodes = new Node[n];
        for (int i = 0; i<n; i++) {
            nodes[i] = new Node();
        }
        
        int totalCost = 0;
        
        for (Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];
            
            if (node1.isConnected(node2)) continue;
            node1.merge(node2);
            totalCost += edge.cost;
        }
        
        return totalCost;
    }
    
    private static class Edge {
        public final int u;
        public final int v;
        public final int cost;
        
        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
    
    private static class Node {
        private Node parent = null;
        
        public boolean isConnected(Node node) {
            return root() == node.root();
        }
        
        public void merge(Node node) {
            if (isConnected(node)) return;
            node.root().parent = this.root();
        }
        
        private Node root() {
            if (parent == null) return this;
            else {
                return parent.root();
            }
        }
    }
}