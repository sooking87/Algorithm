package HeapSort;

import java.io.*;

public class heapify {
    static int[] a;

    public static void heapify(int[] a, int i, int N) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;
        if (leftChild < N && a[leftChild] > a[largest]) {
            largest = leftChild;
        }
        if (rightChild < N && a[rightChild] > a[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, largest, N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        // 최대 힙으로 만들기(heapify)
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(a, i, n);
        }
        // 정렬하기
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, 0, i); //
        }
        // 출력하기
        for (int d : a) {
            bw.write(d + "\n");
        }
        bw.close();
    }
}