package LIST;

class ListNode {
    String data;
    ListNode next;

    public ListNode() {
        this.data = null;
        this.next = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(String data, ListNode next) {
        this.data = data;
        this.next = next;
        this.next = null;
    }

    public String getData() {
        return this.data;
    }
}

public class copyCircleLinkeList {
    private ListNode head;

    public copyCircleLinkeList() {
        this.head = null;
    }

    // 머리 노드에 삽입
    public void addFirst(String str) {
        ListNode ptr = head;
        head = new ListNode(str, ptr);
    }

    // 첫번째 노드에 삽입
    public void insertFirstNode(String str) {
        ListNode node = new ListNode(str);
        if (head == null) {
            head = node;
        } else {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            head = node;
        }
    }

    // 꼬리 노드에 삽입
    public void addLast(String str) {
        ListNode node = new ListNode(str);
        if (head == null) {
            head = node; // 리스트 새로운 노드를 추가
            node.next = node; // 새 노드의 다음 노드가 자기 자신을 가리키게 하여 원형 연결 리스트를 만듬
        } else {
            ListNode current = head; // 첫 번째 노드에 대한 참조값을 current변수에 넣는다.
            while (current.next != head) { // 꼬리 노드까지 이동
                current = current.next;
            }
            // current = 꼬리 노드
            node.next = current.next; // current.next는 헤드 노드이므로 꼬리 노드의 다음 노드를 헤드로 연결
            current.next = node; // (전) 꼬리노드의 다음 노드를 연결(node가 찐 꼬리 노드)
        }
    }

    // 노드 삽입
    public void add(ListNode pre, String str) {
        ListNode node = new ListNode(str);
        if (head == null) {
            head = node;
        } else {
            ListNode current = head;
            while (current.next != pre) {
                current = current.next;
            }
            // current는 pre 앞쪽 노드
            current = current.next; // current.next는 pre노드와 같았는데, 이 코드를 통해서 결국, current는 pre노드가 됨.
            node.next = current.next;
            current.next = node;
        }
    }

    // 마지막 노드 삭제
    public void removeLast() {
        if (head == null) {
            System.out.println("삭제할 노드가 없습니다.");
        } else {
            ListNode prev = head;
            ListNode current = head.next;
            while (current.next != head) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }

    // 첫 번째 노드 삭제
    public void removeFirst() {
        if (head == null) {
            System.out.println("삭제할 노드가 없습니다.");
        } else {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            ListNode old = current.next;
            head = old.next;
            current.next = head;
        }
    }

    // 중간 노드를 삭제
    public void remove(String str) {
        ListNode node = new ListNode(str);
        if (head == null) {
            System.out.println("삭제할 노드가 없습니다.");
        } else {
            ListNode prev = head;
            ListNode current = head.next;
            while (current.data != node.data) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }
}
