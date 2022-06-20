package MergeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class backjoon_2751 {
    static int[] buff;

    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int j = 0;
            int p = 0;
            int k = left;

            __mergeSort(a, left, center);
            __mergeSort(a, center + 1, right);

            // 왼쪽 배열 buff 배열에 복사
            for (i = left; i <= center; i++) {
                buff[p++] = a[i];
            }

            // 왼쪽 배열 + 오른쪽 배열 정렬
            while (i <= right && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }

            // buff 배열의 나머지 요소를 a 배열에 복사 -> buff 배열에 남는 경우 == 뒷부분 배열보다 큰 값이 들어있는 경우
            while (j < p) {
                a[k++] = buff[j++];
            }
        }
    }

    // 병합 정렬
    static void mergeSort(int[] a, int n) {
        buff = new int[n]; // 작업용 배열을 생성
        __mergeSort(a, 0, n - 1); // 배열 전체를 병합 정렬

        buff = null; // 작업용 배열 해제
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, n);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }
}
