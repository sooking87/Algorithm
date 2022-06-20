package LIST;

import java.util.Comparator;

public class CircularLinkedList<E> {
    // 노드
    class Node<E> {
        private E data;
        private Node<E> next;

        // Node<E> 생성자
        Node(E obj, Node<E> next) {
            data = obj;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private Node<E> crnt;

    // CircularLinkedList<E>의 생성자
    public CircularLinkedList() {
        tail = crnt = null;
    }

    // 리스트가 비어 있는가
    public boolean isEmpty() {
        return head.next == head;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // addFirst 메소드
    public void addFirst(E obj) {
        Node<E> ptr = tail.next;
        if (ptr == null) {

        }
    }

    // addLast 메소드
    public void addLast(E obj) {
        if (tail.next == null) {
            addFirst(obj);
        } else {
            Node<E> ptr = tail.next;
            while (ptr != tail.next) {
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, tail.next);
        }
    }

    // removeFirst 메소드
    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    // removeLast 메소드
    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head; // 현재 노드
                Node<E> pre = head; // ptr 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    // remove 메소드
    // 노드 p를 삭제
    public void remove(Node<E> p) {
        if (head == null) {
            removeFirst();
        } else {
            Node<E> ptr = head;
            while (ptr.next != p) {
                ptr = ptr.next;
                if (ptr == null)
                    return; // p가 리스트에 없습니다.
            }
            ptr.next = p.next;
            crnt = ptr;
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드 선택
    public void clear() {
        while (head != null) {
            removeFirst();
        }
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
