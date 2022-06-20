package STACK;

import java.util.Scanner;
import java.util.Stack;

public class backjoon_1874 {
    private int max;
    private int ptr;
    private int[] stk;

    public backjoon_1874(int capacity) {
        ptr = 0;
        max = capacity;
        stk = new int[max];
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        }
        stk[ptr] = data;
        ptr++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        ptr--;
        return stk[ptr];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stk[ptr - 1];

    }

    public void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(stk[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int n = sc.nextInt();
        backjoon_1874 stack = new backjoon_1874(n);
        int top = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > top) {
                for (int j = top + 1; j <= num; j++) {
                    stack.push(j);
                    ans.append("+\n");
                }
                top = num;
                System.out.println("peek: " + stack.peek());
                System.out.println("nums: " + num);
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.print();
            stack.pop();
            ans.append("-\n");
        }
        System.out.println(ans);

    }
}
