package org.example.DFS_BFS.P1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cross = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static double[] percent = new double[4];
    static boolean[][] visited;
    static int N;
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited = new boolean[30][30];
        visited[15][15] = true;

        dfs(15, 15, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt, double result) {
        if (cnt == N) {
            answer += result;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dx = x + cross[i][0], dy = y + cross[i][1];
            if (!visited[dx][dy]) {
                visited[dx][dy] = true;
                dfs(dx, dy, cnt + 1, result*percent[i]);
                visited[dx][dy] = false;
            }
        }
    }
}
