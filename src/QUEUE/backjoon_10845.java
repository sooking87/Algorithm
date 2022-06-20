package QUEUE;

import java.util.LinkedList; //import
import java.util.Queue; //import
import java.util.Scanner;

public class backjoon_10845 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int n = sc.nextInt();
        int last = 0;
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.compareTo("push") == 0) {
                int num = sc.nextInt();
                last = num;
                queue.add(num);
            } else if (command.compareTo("pop") == 0) {
                if (queue.isEmpty()) {
                    ans.append("-1").append("\n");
                } else {
                    ans.append(queue.poll()).append("\n");
                }
            } else if (command.compareTo("size") == 0) {
                ans.append(queue.size()).append("\n");
            } else if (command.compareTo("empty") == 0) {
                ans.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command.compareTo("front") == 0) {
                ans.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else {
                ans.append(queue.isEmpty() ? -1 : last).append("\n");
            }
        }
        System.out.println(ans);
    }
}
