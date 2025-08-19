import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int len = (int) Math.pow(3,n);
            char[] arr = new char[len];
            Arrays.fill(arr, '-');

            recursion(0, len, arr);
            System.out.println(new String(arr));
        }
    }


    private static void recursion(int start, int len, char[] arr){
        if(len == 1) return;
        len /= 3;
        for (int i = start + len; i< start + 2*len ; i++) {
            arr[i] = ' ';
        }

        recursion(start, len, arr);
        recursion(start + 2 * len, len, arr);
    }
}