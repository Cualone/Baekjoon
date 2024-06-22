package org.example.DFS_BFS.P3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[][] cross = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int wolf, sheep;
    static int totalW = 0, totalS = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    wolf = 0;
                    sheep = 0;
                    dfs(i, j);
                    if (wolf >= sheep) {
                        totalW += wolf;
                    } else if (sheep > wolf) {
                        totalS += sheep;
                    }
                }
            }
        }

        System.out.println(totalS + " " + totalW);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (map[x][y] == 'v') {
            wolf++;
        } else if (map[x][y] == 'k') {
            sheep++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + cross[i][0], ny = y + cross[i][1];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if (map[nx][ny] == '#') continue;
            if(!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
