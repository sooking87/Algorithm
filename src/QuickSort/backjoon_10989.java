package QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_10989 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right) {

        /* 실행 과정 살펴보기 */
        System.out.printf("a[%d]~a[%d] : {", left, right);
        for (

                int i = left; i < right; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.printf("%d}\n", a[right]);
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2]; // 피벗

        do {
            while (a[pl] < x)
                pl++;
            while (a[pr] > x)
                pr--;

            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr)
            quickSort(a, left, pr);
        if (pl < right)
            quickSort(a, pl, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        quickSort(nums, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }

    }

}
