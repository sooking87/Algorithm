package InsertionSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class backjoon_24052 {
    static boolean insertionSort(int[] arr, int n, int k) {
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
                cnt++;

                if (cnt == k) {
                    return true;
                }
            }
            if (j != i) {
                arr[j] = temp;
                cnt++;
                if (cnt == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열 개수
        int k = Integer.parseInt(st.nextToken()); // k번 변경
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (insertionSort(arr, n, k)) {
            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
        bw.close();
    }
}
