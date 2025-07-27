class Solution {
    static int m, n;
    static int[][] dpTable;
    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        
        dpTable = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            dpTable[puddle[1]][puddle[0]] = -1;
        }
        
        for (int x = 1; x<=n; x++) {
            for (int y = 1; y<=m; y++) {
                if (x == 1 && y == 1) {
                    dpTable[x][y] = 1;
                } else {
                    if (inMap(x, y) && !isPuddles(x,y)) {
                        dpTable[x][y] = (up(x,y) + left(x,y)) % 1000000007;
                    }
                }
            }
        }
        return dpTable[n][m];
    }
    
    public int up(int x, int y) {
        if (x - 1 >= 1 && dpTable[x - 1][y] != -1) return dpTable[x - 1][y];
        else return 0;
    }
    
    public int left(int x, int y){
        if (y - 1 >= 1 && dpTable[x][y - 1] != -1) return dpTable[x][y - 1];
        else return 0;
    }
    
    public boolean inMap(int x, int y) {
        if (x >= 1 && x <= n && y >= 1 && y <= m) return true;
        else return false;
    }
    
    public boolean isPuddles(int x, int y) {
        if (dpTable[x][y] == -1) return true;
        else return false;
    }
}