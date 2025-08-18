import java.io.*;
import java.util.*;
public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Palindrome result = isPalindrome(st.nextToken());
            sb.append(result.result).append(" ").append(result.count).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
    public static Palindrome recursion(Palindrome p){
        if(p.l >= p.r) {
            p.result = 1;
            p.count = p.count + 1;
            return p;
        }
        else if(p.s.charAt(p.l) != p.s.charAt(p.r)) {
            p.result = 0;
            p.count = p.count + 1;
            return p;
        }
        else return recursion(new Palindrome(p.s, p.l + 1, p.r - 1, p.result, p.count+1));
    }
    public static Palindrome isPalindrome(String s){
        return recursion(new Palindrome(s, 0, s.length() - 1, 0, 0));
    }

    public static class Palindrome {
        String s;
        int l;
        int r;
        int result;
        int count;

        public Palindrome(String s, int l, int r, int result, int count) {
            this.s = s;
            this.l = l;
            this.r = r;
            this.result = result;
            this.count = count;
        }
    }

}