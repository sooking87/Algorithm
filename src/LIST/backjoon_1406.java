package LIST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    Node(E d) {
        this.data = d;
        this.prev = null;
        this.next = null;
    }

    Node(E d, Node<E> prev, Node<E> next) {
        this.data = d;
        this.prev = prev;
        this.next = next;
    }
}

public class backjoon_1406<E> {
    public Node<E> head;
    public Node<E> tail;
    public Node<E> crnt;
    public int size;

    public backjoon_1406() {
        head = new Node<E>(null);
        crnt = new Node<E>(null);
        tail = new Node<E>(null);
        this.size = 0;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj);
        if (size == 0) {
            System.out.println("if");
            head.next = node;
            node.prev = head;
            tail.prev = node;
            node.next = tail;
        } else {
            System.out.println("else");
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            node.next = tail;
        }
        crnt = tail;
        size++;
        this.printAll();
        System.out.println(crnt.data);
    }

    public void shiftLeft() {
        System.out.println("맨앞 아님");
        if (crnt != head) {
            crnt = crnt.prev;
        }
        this.printAll();
        System.out.println(crnt.data);
    }

    public void shiftRight() {
        if (crnt != tail) {
            System.out.println("맨뒤 아님");
            crnt = crnt.next;
        }
        this.printAll();
        System.out.println(crnt.data);
    }

    public void delete() {
        if (crnt != head) {
            crnt.prev = crnt.prev.prev;
            crnt.prev.next = crnt;
        }
        this.printAll();
        System.out.println(crnt.data);
    }

    public void push(E value) {
        Node<E> node = new Node<E>(value, crnt.prev, crnt);
        crnt.prev = node;
        node.prev = crnt.prev;
        crnt = node;
        size++;
        this.printAll();
        System.out.println(crnt.data);
    }

    public void printAll() {
        if (size == 0) {
            System.out.println("출력 X");
        } else {
            Node<E> ptr = head.next;
            int cnt = 0;
            while (cnt < size) {
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
                cnt++;
            }
        }
        System.out.println();
        System.out.println(crnt.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        backjoon_1406<String> list = new backjoon_1406<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        list.printAll();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            System.out.println(command.length);
            if (command[0].compareTo("L") == 0) {
                list.shiftLeft();
            } else if (command[0].compareTo("D") == 0) {
                list.shiftRight();
            } else if (command[0].compareTo("B") == 0) {
                list.delete();
            } else {
                list.push(command[1]);
            }
        }
        list.printAll();
    }
}
