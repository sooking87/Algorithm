package InsertionSort;

import java.util.Scanner;

public class InsertSort {

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int temp = a[i];
            // 반복문을 돌면서 temp가 들어갈 자리를 찾는다.
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                a[j] = a[j - 1]; // 한 칸 오른쪽으로 이동
            }
            // temp가 들어갈 자리에 temp값을 넣어준다.
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("오름 차순 정렬 완료");
        for (int i = 0; i < nx; i++) {
            System.out.println("n[" + i + "] = " + x[i]);
        }
    }

}
