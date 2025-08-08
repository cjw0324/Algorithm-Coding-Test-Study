import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[][] items = new int[n][2]; // 물건들의 {무게, 가치} 가 들어있는 2차원 배열 
        for (int i = 0; i<n; i++) {
            items[i][0] = kb.nextInt();
            items[i][1] = kb.nextInt();
        }
        
        int[][] dpTable = new int[n+1][k+1];
        
        for (int x = 1; x<n+1; x++) {
            for (int y = 1; y<k+1; y++) {
                int w = items[x - 1][0];
                int v = items[x - 1][1];
                
                int up = dpTable[x-1][y]; // 선택된 물건을 포함하지 않는 경우
                int cross = 0;
                if (y - w >= 0) {
                    cross = dpTable[x - 1][y - w] + v;
                }
                
                dpTable[x][y] = Math.max(up, cross);
            }
        }
        
        System.out.println(dpTable[n][k]);
    }
}