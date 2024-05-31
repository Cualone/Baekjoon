package org.example.P21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static boolean[][] visited;
    static int N, M;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int doI = 0, doJ = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    doI = i;
                    doJ = j;
                }
            }
        }

        floodFill(doI, doJ);
        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static void floodFill(int i, int j) {
        if (map[i][j] == 'P') cnt++;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + cross[k][0], y = j + cross[k][1];
            if (x < 0 || x >= N || y < 0 || y >= M) continue;
            if (map[x][y] == 'X' || map[x][y] == 'I') continue;
            if (!visited[x][y]) {
                floodFill(x, y);
            }
        }
    }
}
