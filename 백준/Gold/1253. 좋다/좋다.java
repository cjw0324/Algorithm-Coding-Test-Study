import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);
        
        if(arr.length < 3) System.out.println(0);
        else {
    		System.out.println(new Main().solution(n, arr));        
        }
	}
    
    public int solution(int n, int[] arr) {
        int answer = 0;
        for(int i = 0; i<n; i++) {
            int lt = 0;
            int rt = n-1;
            while (lt<rt) {
                if (lt == i) {
                    lt++;
                    continue;
                }
                
                if (rt == i) {
                    rt--;
                    continue;
                }
                
                
                if(arr[lt] + arr[rt] == arr[i]) {
                    answer++;
                    break;
                } else if (arr[lt] + arr[rt] > arr[i]) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }
        return answer;
    }
}