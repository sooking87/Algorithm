package LIST;

public class Test<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            this.data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    // DbLinkedList<E>의 생성자
    public Test() {
        head = crnt = new Node<E>();
    }

    public void add(E obj) {
        Node<E> node = new Node(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void rotate() {
        for (int i = 0; i < 5; i++) {
            if (crnt == head) {
                crnt = crnt.next;
                continue;
            }
            System.out.println(crnt.data);
            crnt = crnt.next;
        }
    }

    public static void main(String[] args) {
        Test<Integer> test = new Test<Integer>();
        test.add(1);
        test.add(4);
        test.rotate();
    }
}
