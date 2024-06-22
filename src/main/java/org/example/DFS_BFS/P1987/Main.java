package org.example.DFS_BFS.P1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        HashSet<Character> path = new HashSet<>();
        path.add(board[0][0]);
        visited[0][0] = true;
        dfs(0, 0, path);
        System.out.println(maxCount);
    }

    static void dfs(int r, int c, HashSet<Character> path) {
        maxCount = Math.max(maxCount, path.size());
        for (int i = 0; i < 4; i++) {
            int x = r + cross[i][0], y = c + cross[i][1];
            if (x < 0 || x >= R || y < 0 || y >= C) continue;
            if (visited[x][y] || path.contains(board[x][y])) continue;
            visited[x][y] = true;
            path.add(board[x][y]);
            dfs(x, y, path);
            path.remove(board[x][y]);
            visited[x][y] = false;
        }
    }
}
