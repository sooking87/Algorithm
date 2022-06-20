package LIST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class 백준_손수경_정답_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.print("<");
        while (!list.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    int a = list.remove();
                    if (list.size() == 0) {
                        System.out.print(a);
                    } else {
                        System.out.print(a + " ");
                    }
                } else {
                    list.add(list.remove());
                }
            }
        }
        System.out.println(">");
    }
}
