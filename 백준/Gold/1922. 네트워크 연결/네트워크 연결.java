import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        
        int answer = 0;
        
        int[][] edgeTemp = new int[m][3];
        
        for (int i = 0; i<m; i++) {
            edgeTemp[i][0] = kb.nextInt() -1;
            edgeTemp[i][1] = kb.nextInt() -1;
            edgeTemp[i][2] = kb.nextInt();
        }
        
        Arrays.sort(edgeTemp, (a,b) -> a[2] - b[2]);
        
        Edge[] edges = new Edge[m];
        Node[] nodes = new Node[n];
        for (int i = 0; i<n ; i++) {
            nodes[i] = new Node();
        }
        
        for (int i = 0; i<m; i++) {
            edges[i] = new Edge(edgeTemp[i][0], edgeTemp[i][1], edgeTemp[i][2]);
        }
        
        for (Edge e : edges) {
            Node node1 = nodes[e.u];
            Node node2 = nodes[e.v];
            if (!node1.isConnected(node2)) {
                node1.merge(node2);
                answer += e.cost;
            } 
        }
        
        System.out.println(answer);
	}
    
    public static class Edge {
        int u;
        int v;
        int cost;
        
        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
    
    public static class Node {
        public Node parent = null;
        
        public boolean isConnected(Node o) {
            return this.root() == o.root();
        } 
        public void merge(Node o) {
            if (isConnected(o)) return;
            else {
                o.root().parent = this.root();
            }
        }
        public Node root() {
            if (parent == null) return this;
            else {
                return parent.root();
            }
        }
    }
}