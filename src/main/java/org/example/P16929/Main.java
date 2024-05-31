package org.example.P16929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int[][] cross = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int N, M;
    static String answer;
    static int startX, startY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        answer = "No";

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                startX = i;
                startY = j;
                visited[startX][startY] = true;
                dfs(startX, startY, 1);
                if (answer.equals("Yes")) break;
            }
            if (answer.equals("Yes")) break;
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt) {

        for (int i = 0; i < 4; i++) {
            int nx = x + cross[i][0], ny = y + cross[i][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (board[x][y] != board[nx][ny]) continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1);
                visited[nx][ny] = false;
            } else if (nx == startX && ny == startY && cnt >= 4) {
                answer = "Yes";
                return;
            }
        }
    }
}
