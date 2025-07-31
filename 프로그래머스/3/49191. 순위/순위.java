class Solution {
    static boolean[][] graph;
    static int[][] results;
    static int n;
    public int solution(int n, int[][] results) {
        this.n = n;
        graph = new boolean[n+1][n+1]; // index 1 부터 1번 선수로 생각하기 위해 n+1 크기 만큼 설정해 줌.
        for (int[] result : results) { //[4,3] 이라면, 4가 3을 이긴 상황이다. 이를 인접 행렬 그래프로 표현하면, table[4][3] = true 가 된다.
            graph[result[0]][result[1]] = true;
        }
        this.results = results.clone();
        
        boolean[] visited;
        int count = 0;
        for (int i = 1; i<=n; i++) {
            int wins = win(i, new boolean[n+1]);
            int lose = lose(i, new boolean[n+1]);
            System.out.println(wins +", "+lose);
            if (wins + lose -1 == n) count++;
        }
        return count;
    }
    
    public int win(int u, boolean[] visited) {
        int count = 1;
        for (int v = 1; v<=n; v++) {
            if (graph[u][v] && !visited[v]) {
                visited[v] = true;
                count += win(v,visited);
            }
        }
        return count;
    }
    
    public int lose(int u, boolean[] visited) {
        int count = 1;
        for (int v = 1; v<=n; v++) {
            if (graph[v][u] && !visited[v]) {
                visited[v] = true;
                count += lose(v, visited);
            }
        }
        return count;
    }
}