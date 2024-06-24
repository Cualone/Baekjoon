package org.example.DFS_BFS.P15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, team;
    static int[][] status;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        status = new int[N][N];
        visited = new boolean[N];
        team = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (team = 1; team < N; team++) {
            dfs(0, 0);
        }
        System.out.println(min);
    }

    static void dfs(int idx, int cnt) {

        if (cnt == team) {
            solve();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static void solve() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += status[i][j];
                    start += status[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += status[i][j];
                    link += status[j][i];
                }
            }
        }

        if (start == link) {
            min = 0;
            return;
        }

        min = Math.min(min, Math.abs(start - link));
    }
}
