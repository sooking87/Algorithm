package HeapSort;

import java.util.Scanner;

public class HeapSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // a[left] ~ a[right]를 힙으로 만듭니다.
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left]; // 루트
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1; // 왼쪽 자식
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰 값을 가진 노드를 자식에 대입
            if (temp >= a[child]) {
                break;
            }
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    // 힙 정렬
    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i); // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a, 0, i - 1); // a[0] ~ a[i-1]을 힙으로 만들어줌.
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.printf("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx);

        System.out.println("오름차순 정렬 완료");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
