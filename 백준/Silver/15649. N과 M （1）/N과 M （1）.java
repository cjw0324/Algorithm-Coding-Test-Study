import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0,"",new boolean[n]);
        Collections.sort(answer);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    static void dfs(int depth, String str, boolean[] visited) {
        if (depth == m) {
            answer.add(str.trim());
        }
        else {
            for (int next = 1; next <= n; next++) {
                if (!visited[next - 1]) {
                    visited[next - 1] = true;
                    dfs(depth+1,str + " " + next, visited);
                    visited[next - 1] = false;
                }
            }
        }
    }
}