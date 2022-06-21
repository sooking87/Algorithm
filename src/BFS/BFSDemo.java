package BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class BFSDemo {
    private int n; // 노드의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트

    BFSDemo(int size) {
        n = size;
        adj = new LinkedList[size];
        for (int i = 0; i < size; ++i)
            adj[i] = new LinkedList();
    }

    // 노드 연결
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // root를 시작 노드로 BFS로 탐색하면서 탐색한 노드를 출력
    void BFS(int root) {
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐 생성

        // 1. 루트 노드를 방문하면서 BFS 시작
        visited[root] = true;
        queue.add(root);

        // 2. 모든 노드가 큐에 삽입 && 삭제 될 때까지 반복
        while (!queue.isEmpty()) {
            root = queue.poll(); // DeQueue
            System.out.print(root + 1 + " ");

            Iterator<Integer> i = adj[root].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                // 다음 노드가 방문하지 않은 노드라면
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSDemo g = new BFSDemo(8);

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
