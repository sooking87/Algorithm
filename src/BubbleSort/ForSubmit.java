package BubbleSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class ForSubmit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        // 배열 요소 입력받기
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (Integer i : arr) {
            bw.write(i + "\n");
        }
        bw.close();
    }
}
