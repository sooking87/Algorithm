package BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class BFSCopy {
    private int V; // 노드의 개수
    private LinkedList<Integer> adj[]; // 리스트

    // 생성자
    BFSCopy(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) // 리스트 초기화
            adj[i] = new LinkedList();
    }

    // 노드 연결
    void addEdge(int v, int w) {
        adj[v].add(w); // v -> w
        adj[w].add(v); // w -> v
    }

    // s를 시작 노드로 BFS로 탐색하면서 탐색한 노드 출력
    void BFS(int s) {
        boolean visited[] = new boolean[V]; // 노드의 방문 여부 확인
        Queue<Integer> Q = new LinkedList<>(); // BFS를 위한 큐 생성

        visited[s] = true; // 현재 노드를 방문한 것으로 표시
        Q.add(s); // 큐에 삽입

        while (!Q.isEmpty()) {// 큐가 빌 때까지 반복
            s = Q.poll();
            System.out.print(s + 1 + " "); // 데이터 처리 -> print로 대체

            // 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화 -> Iterator
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) { // 방문하지 않은 노드인지 확인
                    visited[n] = true;
                    Q.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSCopy g = new BFSCopy(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 7);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        g.BFS(0);

    }
}