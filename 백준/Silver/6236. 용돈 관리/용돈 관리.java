import java.util.*;
public class Main {
    static int[] waste;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        waste = new int[n];
        for(int i = 0; i<n; i++){
            waste[i] = kb.nextInt();
        }
        
        System.out.println(new Main().solution(n,m));
    }
    
    
    public int solution(int n, int m) {
        int start = Arrays.stream(waste).max().getAsInt();
        int end = Arrays.stream(waste).sum();
        
        int answer = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if (m >= getMoneyCount(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
        
    }
    
    
    public int getMoneyCount(int k){
        int money = 0;
        int count = 0;
        
        for (int w : waste) {
            if (money < w) {
                count++;
                money = k - w;
            } else {
                money -= w;
            }   
        }
        return count;
    }
}