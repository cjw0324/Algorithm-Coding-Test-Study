import java.util.*;
class Solution {
    static int[][] dpTable;
    static int[] dx = {-1, 0};
    static int[] dy = {0, -1};
    public int solution(int m, int n, int[][] puddles) {
        dpTable = new int[n][m];
        for (int[] puddle : puddles) {
            dpTable[puddle[1]-1][puddle[0]-1] = -1;
        }
        dpTable[0][0] = 1;
        
        
        
        for (int x = 0; x<n; x++) {
            for (int y = 0; y<m; y++) {
                if (dpTable[x][y] == -1 || (x==0 && y==0)) continue;
                int route = dpTable[x][y];
                for (int i = 0; i<2; i++) {
                    if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m) {
                        if (dpTable[x+dx[i]][y+dy[i]] == -1) {
                            continue;
                        } else {
                            route += dpTable[x+dx[i]][y + dy[i]];
                        }
                    }
                }
                dpTable[x][y] = route % 1000000007;
            }
        }
        
        // for (int[] r : dpTable) {
        //     System.out.println(Arrays.toString(r));
        // }
        
        return dpTable[n-1][m-1];
    }
}