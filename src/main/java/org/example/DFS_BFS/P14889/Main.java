package org.example.DFS_BFS.P14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team(0, 0);

        System.out.println(Min);


    }

    static void team(int idx, int cnt) {
        if (cnt == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                team(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (!visited[i] && !visited[j]){
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            Min = val;
            return;
        }

        Min = Math.min(Min, val);
    }
}
