package org.example.DFS_BFS.P1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int maxTrash = 0;

        map = new int[N+1][M+1];    // [세로][가로]
        visited = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    maxTrash = Math.max(maxTrash, dfs(i, j));
                }
            }
        }
        System.out.println(maxTrash);
    }

    static int dfs(int y, int x) {
        int cnt = 1;
        visited[y][x] = true;
        for (int next = 0; next < 4; next++) {
            int nx = x + cross[next][0], ny = y + cross[next][1];
            if (nx < 1 || nx > M || ny < 1 || ny > N) continue;
            if (map[ny][nx] == 0) continue;
            if (visited[ny][nx]) continue;
            cnt += dfs(ny, nx);
        }
        return cnt;
    }
}