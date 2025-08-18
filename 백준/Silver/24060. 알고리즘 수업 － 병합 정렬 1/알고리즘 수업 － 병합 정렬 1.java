import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int k;
    static int[] arr;
    static int[] sorted;
    static int answer = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sorted = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr,0, n-1);

//        System.out.println(Arrays.toString(arr));
        if (count < k) System.out.println(-1);
        else {
            System.out.println(answer);
        }
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                sorted[idx] = arr[l];
                l++;
                idx++;
            } else {
                sorted[idx] = arr[r];
                r++;
                idx++;
            }
        }

        if (l > mid) {
            while(r <= right) {
                sorted[idx] = arr[r];
                r++;
                idx++;
            }
        }
        else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                l++;
                idx++;
            }
        }

        for (int i = left; i<= right; i++) {
            count++;
            if (count == k) {
                answer = sorted[i];
            }
            arr[i] = sorted[i];
        }
    }



}