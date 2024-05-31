package org.example.P1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[][] cross = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int R, C, K;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(result);

    }

    static void dfs(int x, int y, int cnt) {

        if (x == 0 && y == C - 1 && cnt == K) {
            result++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + cross[i][0], ny = y + cross[i][1];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
            if (map[nx][ny] == 'T') continue;

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visited[nx][ny] = false;
            }

        }
    }
}
