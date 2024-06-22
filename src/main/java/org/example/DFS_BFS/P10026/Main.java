package org.example.DFS_BFS.P10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static char[][] img = new char[100][100];
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static boolean[][] visited = new boolean[100][100];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                img[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt1++;
                }
            }
        }
        visited = new boolean[100][100];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (img[i][j] == 'G') {
                    img[i][j] = 'R';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt2++;
                }

            }
        }
        System.out.println(cnt1);
        System.out.println(cnt2);

    }

    static void dfs(int i, int j) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            visited[curr[0]][curr[1]] = true;
            for (int k = 0; k < 4; k++) {
                int x = curr[0] + cross[k][0], y = curr[1] + cross[k][1];
                if (x < 0 || y < 0 || x > N-1 || y > N-1) continue;
                if (visited[x][y]) continue;
                if (img[curr[0]][curr[1]] != img[x][y]) continue;
                stack.push(new int[]{x, y});
            }
        }
    }
}
