package STACK;

interface DStack {
    boolean isEmpty();

    boolean isFull();

    void push(Object data);

    void pop();

    void peek();

    void clear();
}

class Node {
    Object data;
    Node next;

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return this.data;
    }
}

public class ListStack implements DStack {
    Node head;
    Node top;
    int stackSize; // 배열의 개수

    public ListStack(int size) {
        this.head = null;
        this.top = null;
        stackSize = size;
    }

    public boolean isEmpty() {
        return null == top;
    }

    public boolean isFull() {
        if (isEmpty()) {
            return false;
        } else {
            int nodeCount = 0;
            Node ptr = head;
            while (ptr.next != null) {
                ++nodeCount;
                ptr = ptr.next;
            }
            return this.stackSize - 1 == nodeCount;
        }
    }

    public void push(Object data) {
        Node node = new Node();
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        } else if (isEmpty()) {
            this.head = node;
            this.top = this.head;
        } else {
            Node ptr = top;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = node;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        // 스택에 노드가 한 개 남았을 경우
        else if (top.next == null) {
            top = null;
            head = null;
        } else {
            Node ptr = top.next;
            Node pre = top;
            while (ptr.next != null) {
                pre = ptr;
                ptr = ptr.next;
            }
            pre.next = null;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        } else {
            Node ptr = top;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            System.out.println(ptr.getData());
        }
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        head = null;
        top = null;
    }
}
