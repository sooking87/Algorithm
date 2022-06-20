package MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortTest {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        Arrays.sort(x);

        System.out.println("오름차순 완료");
        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
