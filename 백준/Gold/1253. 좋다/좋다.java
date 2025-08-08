import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        int answer = 0;
        
        Arrays.sort(arr);
        
        for (int i = 0; i<n; i++) {
            int lt = 0;
            int rt = n-1;
            
            while(lt<rt){
                if (lt == i) {
                    lt++;
                    continue;
                }
                if (rt == i) {
                    rt--;
                    continue;
                }                
                if (arr[lt] + arr[rt] == arr[i]) {
                    answer++;
                    break;
                }
                else if (arr[lt] + arr[rt] < arr[i]) {
                    lt++;
                } else {
                    rt--;
                }
                
            }
        }
        
        System.out.println(answer);
    }
}