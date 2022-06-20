package LIST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DbLinkedListTest<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DbLinkedListTest() {
        head = crnt = new Node<E>(); // 더미 노드
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
        // System.out.print("add ");
        // printAll();
    }

    public void remove(Node<E> crnt) {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;

            // System.out.print("remove ");
            // printAll();
        }
    }

    public E moveK(int range) {
        int cnt = 0;
        Node<E> ptr = crnt.next;
        // System.out.println("moveK, ptr.data " + ptr.data);
        while (cnt != range - 1) {
            if (ptr == head) { // head가 가리키는 노드는 더미 노드 이므로 카운트 하지 않음
                System.out.println("moveK, ptr == head " + ptr.data);
                ptr = ptr.next;
                continue;
            }
            System.out.println("moveK, ptr != head " + ptr.data);
            cnt++;
            ptr = ptr.next;
        }
        crnt = ptr;
        if (crnt == head) {
            crnt = crnt.next;
        }
        System.out.println(crnt.data);
        remove(crnt);
        return crnt.data;
    }

    public void printAll() {
        Node<E> ptr = head.next;
        System.out.print("<");
        while (ptr.next != head) { // 꼬리 노드 전까지 출력
            System.out.print(ptr.data + ", ");
            ptr = ptr.next;
        }
        System.out.println(ptr.data + ">");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        DbLinkedListTest<Integer> list = new DbLinkedListTest<>();
        DbLinkedListTest<Integer> printList = new DbLinkedListTest<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < n; i++) {
            int num = list.moveK(k);
            printList.add(num);
        }
        printList.printAll();
    }

}
