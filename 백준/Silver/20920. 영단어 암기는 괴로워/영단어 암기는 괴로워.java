import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i<n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Word w : list) {
            sb.append(w.word).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static class Word implements Comparable<Word>{
        String word;
        int length;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.length = word.length();
            this.count = count;
        }

        @Override
        public int compareTo(Word w) {
            if (this.count == w.count) {
                if (this.length == w.length) {
                    return this.word.compareTo(w.word);
                } else {
                    return w.length - this.length;
                }
            } else {
                return w.count - this.count;
            }
        }
    }
}