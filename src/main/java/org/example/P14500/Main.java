package org.example.P14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] cross = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static int[][] board;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 'ㅜ' 모양 회전
                other(i, j, board[i][j]);

                // 연속된 4개로 만들 수 있는 테트로미노
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static boolean inRange(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= M) {
            return false;
        } else return true;
    }

    // 십자에서 가장 작은 값을 빼면 그 칸 중심으로 구해지는 'ㅜ' 합이 최대
    static void other(int i, int j, int sum) {
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int k = 0; k < 4; k++) {
            int ni = i + cross[k][0];
            int nj = j + cross[k][1];
            if (inRange(ni, nj)) {
                sum += board[ni][nj];
                min = Math.min(min, board[ni][nj]);
                cnt++;
            }
        }

        if (cnt == 3) {
            max = Math.max(max, sum);
        } else if (cnt == 4) {
            max = Math.max(max, sum - min);
        }
    }

    static void dfs(int i, int j, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ni = i + cross[k][0];
            int nj = j + cross[k][1];
            if (inRange(ni,nj) && !visited[ni][nj]) {
                visited[ni][nj] = true;
                dfs(ni, nj, cnt + 1, sum + board[ni][nj]);
                visited[ni][nj] = false;
            }
        }
    }
}
