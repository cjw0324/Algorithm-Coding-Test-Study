class Solution {
    
    static boolean[] check;
    static int[][] graph;
    static int N;
    public int solution(int n, int[][] computers) {
        check = new boolean[n];
        N = n;
        graph = computers.clone();
        int answer = 0;
        
        for (int i = 0; i<n; i++) {
            if (!check[i]) {
                DFS(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void DFS(int i){
        for (int j = 0; j<N; j++) {
            if (i!=j && !check[j] && graph[j][i] == 1) {
                check[j] = true;
                DFS(j);
            }
        }
    }
}