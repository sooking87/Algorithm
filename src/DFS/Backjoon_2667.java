package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Backjoon_2667 {
    static int n; // 입력 받을 n
    static int cnt; // 집을 셀 cnt

    static int house[][]; // 지도 입력 배열
    static boolean check[][]; // 방문 여부

    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        house = new int[n][n];
        check = new boolean[n][n];

        // 1. 지도 입력 받기
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < n; j++) {
                house[i][j] = temp.charAt(j) - '0';
            }
        }

        // 2. 단지 방문
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (house[i][j] == 1 && check[i][j] == false) {
                    cnt = 1;
                    dfs(i, j);
                    arr.add(cnt);
                }
            }
        }

        // 3. 출력
        System.out.println(arr.size());
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    static void dfs(int checkRow, int checkCol) {
        // dfs 1. 방문한 노드를 true로 바꾸고
        check[checkRow][checkCol] = true;
        // dfs 2. 주변에 방문 안한 노드를 찾기
        // 현재 탐색한 노드 기준 상
        if (checkRow > 0 && house[checkRow - 1][checkCol] == 1 && check[checkRow - 1][checkCol] == false) {
            cnt++;
            dfs(checkRow - 1, checkCol);
        }
        // 현재 탐색한 노드 기준 하
        if (checkRow < n - 1 && house[checkRow + 1][checkCol] == 1 && check[checkRow + 1][checkCol] == false) {
            cnt++;
            dfs(checkRow + 1, checkCol);
        }
        // 현재 탐색한 노드 기준 좌
        if (checkCol > 0 && house[checkRow][checkCol - 1] == 1 && check[checkRow][checkCol - 1] == false) {
            cnt++;
            dfs(checkRow, checkCol - 1);
        }
        // 현재 탐색한 노드 기준 우
        if (checkCol < n - 1 && house[checkRow][checkCol + 1] == 1 && check[checkRow][checkCol + 1] == false) {
            cnt++;
            dfs(checkRow, checkCol + 1);
        }

    }
}
