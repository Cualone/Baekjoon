package org.example.DFS_BFS.P2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[][] cross = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        int cnt;
        int maxcnt = 0;
        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] > max) max = graph[i][j];
            }
        }

        for (int i = 0; i <= max; i++) {
            visited = new boolean[N][N];
            cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && graph[j][k] > i) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            if (cnt > maxcnt) maxcnt = cnt;
        }
        System.out.println(maxcnt);
    }

    public static void dfs(int x, int y, int rain) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            for (int i = 0; i < cross.length; i++) {
                int nx = curr[0] + cross[i][0], ny = curr[1] + cross[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (graph[nx][ny] <= rain) continue;
                if (visited[nx][ny]) continue;
                stack.push(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}
