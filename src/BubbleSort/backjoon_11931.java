package BubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_11931 {
    public static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    public static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                    exchg++;
                }
            }

            if (exchg == 0)
                break;
        }
    }

    public static void printAll(int[] arr, int n) {
        for (int j = 0; j < n; j++) {
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 배열 요소 입력받기
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        bubbleSort(arr, n);

        printAll(arr, n);
    }
}
