package SelectionSort;

public class SelectionSort {
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            for (int k = 0; k < n; k++) {
                System.out.print(a[k]);
            }
            System.out.println();
            swap(a, i, min);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] num = { 5, 3, 6, 2, 1, 4 };
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
        System.out.println();
        selectionSort(num, num.length);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
    }
}
