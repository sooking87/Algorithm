package LIST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2346<E> {
    // 노드
    class Node<E> {
        private E data;
        private int index;
        private Node<E> prev;
        private Node<E> next;

        // Node<E> 생성자
        Node() {
            data = null;
            prev = next = this;
        }

        // Node<E> 생성자
        Node(E obj, int idx, Node<E> prev, Node<E> next) {
            data = obj;
            index = idx;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public backjoon_2346() {
        head = crnt = new Node<E>(); // 더미 노드
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public void add(E obj, int index) {
        Node<E> node = new Node<E>(obj, index, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void remove() {
        int data = (int) crnt.data;
        crnt.prev.next = crnt.next;
        crnt.next.prev = crnt.prev;
        crnt = crnt.prev;
        move(data);
    }

    public void setFirst() {
        Node<E> ptr = crnt;
        System.out.println(1);
        ptr = ptr.next.next;
        crnt = ptr;

        System.out.println("setRemoveData, crnt.data: " + crnt.data);
        remove();

    }

    public void move(int data) {
        int absData = data < 0 ? -data : data;
        System.out.println("data: " + data + ", absData: " + absData);
        Node<E> ptr = crnt;
        int cnt;

        // remove메소드에서 crnt로 설정해놓은 것이 지운 것보다 앞쪽 노드이므로 지운 노드의 데이터가 음수라면 한번 적게 이동시켜야됨
        if (data == absData) {
            cnt = 0;
        } else {
            cnt = 1;
        }

        while (cnt != absData) {
            if (data == absData) {
                ptr = ptr.next;
                if (ptr == head) {
                    ptr = ptr.next;
                }
            } else {
                ptr = ptr.prev;
                if (ptr == head) {
                    ptr = ptr.prev;
                }
            }
            System.out.println("move, ptr.data: " + ptr.data);
            cnt++;
        }
        crnt = ptr;
        System.out.println(crnt.index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int index = 1;
        backjoon_2346<Integer> list = new backjoon_2346<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp, index);
            index++;
        }

        // 처음에 무조건 1번 풍선부터 터트리기 때문에 setFirst를 통해서 1번 풍선은 터트리고 시작하므로 n - 1번만 반복문 돌리면 됨
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                list.setFirst();
            } else {
                list.remove();
            }
        }
    }
}
