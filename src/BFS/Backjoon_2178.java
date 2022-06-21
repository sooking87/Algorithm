package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2178 {
    static int n, m;
    static int[][] dist;
    static String[] A; // 미로 입력받기 위한 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new String[n];
        for (int i = 0; i < n; i++) {
            A[i] = br.readLine();
        }

        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1); // 배열을 -1 로 초기화
        }

        BFS(0, 0);
        System.out.println(dist[n - 1][m - 1]);
    }

    static void BFS(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x); // x좌표
        Q.add(y); // y좌표
        dist[x][y] = 1; // 시작 칸 1로 초기화 -> 방문 O
        int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // 갈 수 있는 방향 (남, 동, 북, 서)

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0]; // 다음 x좌표 후보
                int ny = y + dir[i][1]; // 다음 y좌표 후보
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue; // 미로 범위 안에 있는지 확인
                if (A[nx].charAt(ny) == '0') // 0이면 길이 존재하지 않으므로 갈 수 없다.
                    continue;
                if (dist[nx][ny] != -1) // -1이 아니라는 것은 이미 방문을 했다는 뜻(처음에 -1로 초기화 시켰으므로)
                    continue;

                dist[nx][ny] = dist[x][y] + 1; // 방문 처리
                Q.add(nx);
                Q.add(ny);

            }
        }

    }
}
