package org.example.DFS_BFS.P1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int N, M;
    static int result;
    static char[][] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = 0;

        tile = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                tile[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (tile[x][y] == '-') {
            int ny = y + 1;
            if ( ny < M && tile[x][ny] == '-') {
                dfs(x, ny);
            }
        } else {
            int nx = x + 1;
            if (nx < N && tile[nx][y] == '|') {
                dfs(nx, y);
            }
        }
    }
}