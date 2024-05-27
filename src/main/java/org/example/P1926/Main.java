package org.example.P1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] image;
    static boolean[][] visited;
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int maxArea = 0;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int imgCnt = 0;

        image = new int[n][m];  // [세로][가로]
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (image[i][j] == 1 && !visited[i][j]) {
                    imgCnt++;
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }

        System.out.println(imgCnt);
        System.out.println(maxArea);
    }

    static int dfs(int i, int j) {
        visited[i][j] = true;
        int area = 1;

        for (int k = 0; k < 4; k++) {
            int ny = i + cross[k][0], nx = j + cross[k][1];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (image[ny][nx] == 0) continue;
            if (!visited[ny][nx]) {
                area += dfs(ny, nx);
            }
        }
        return area;
    }
}
