import java.io.*;
import java.util.*;


public class Main {
    static int[] inOrder, postOrder;
    static int n;
    static int[] index;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        index = new int[n + 1];

        for (int i = 0; i < n; i++) {
            index[inOrder[i]] = i;
        }

        solve(0, n - 1, 0, n - 1);
        System.out.println(sb.toString().trim());
    }

    static void solve(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) return;
        int root = postOrder[pe];
        int rootIndex = index[root];
        sb.append(root).append(" ");
        int leftTreeDepth = rootIndex - is;
        solve(is, rootIndex - 1, ps, ps + leftTreeDepth - 1);
        solve(rootIndex + 1, ie, ps + leftTreeDepth, pe - 1);
    }
}
