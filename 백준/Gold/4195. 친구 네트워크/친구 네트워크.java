import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static HashMap<String, Relation> parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!parent.containsKey(name1)) {
                    parent.put(name1, new Relation(name1, 1));
                }
                if (!parent.containsKey(name2)) {
                    parent.put(name2, new Relation(name2, 1));
                }

                union(name1, name2);

                sb.append(parent.get(find(name1)).size).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void union(String s1, String s2) {
        s1 = find(s1);
        s2 = find(s2);

        if (s1.equals(s2)) {
            return;
        }

        if (parent.get(s1).size < parent.get(s2).size) {
            parent.get(s1).p = s2;
            parent.get(s2).size += parent.get(s1).size;
        } else {
            parent.get(s2).p = s1;
            parent.get(s1).size += parent.get(s2).size;
        }
    }

    static String find(String s) {
        if (parent.containsKey(s) && parent.get(s).p.equals(s)) {
            return s;
        }

        return parent.get(s).p = find(parent.get(s).p);
    }

    static class Relation {
        String p;
        int size;

        public Relation(String p, int size) {
            this.p = p;
            this.size = size;
        }
    }
}